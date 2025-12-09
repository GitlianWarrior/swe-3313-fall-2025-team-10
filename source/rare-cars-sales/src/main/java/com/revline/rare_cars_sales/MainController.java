package com.revline.rare_cars_sales;

import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {

    private final CarRepository carRepository;
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public MainController(CarRepository carRepository, OrderRepository orderRepository, UserRepository userRepository) {
        this.carRepository = carRepository;
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    //INVENTORY & SEARCH
    @GetMapping("/cars")
    public List<Car> getInventory(@RequestParam(required = false) String search) {
        if (search == null || search.isBlank()) {
            return carRepository.findByIsSoldFalse();
        } else {
            return carRepository.searchAvailableCars(search);
        }
    }

    //SHOPPING CART (Session Based)
    private List<Car> getCartFromSession(HttpSession session) {
        List<Car> cart = (List<Car>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
            session.setAttribute("cart", cart);
        }
        return cart;
    }

    @GetMapping("/cart")
    public List<Car> getCart(HttpSession session) {
        return getCartFromSession(session);
    }

    @PostMapping("/cart/add/{carId}")
    public ResponseEntity<?> addToCart(@PathVariable Long carId, HttpSession session) {
        Car car = carRepository.findById(carId).orElse(null);
        if (car == null || car.isSold()) {
            return ResponseEntity.badRequest().body("Car unavailable");
        }

        List<Car> cart = getCartFromSession(session);
        // Prevent adding duplicates
        if (cart.stream().noneMatch(c -> c.getCarID().equals(carId))) {
            cart.add(car);
        }
        return ResponseEntity.ok(cart);
    }

    @PostMapping("/cart/remove/{carId}")
    public ResponseEntity<?> removeFromCart(@PathVariable Long carId, HttpSession session) {
        List<Car> cart = getCartFromSession(session);
        cart.removeIf(c -> c.getCarID().equals(carId));
        return ResponseEntity.ok(cart);
    }

    // CHECKOUT
    @PostMapping("/checkout")
    public ResponseEntity<?> checkout(@RequestBody CheckoutRequest request, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) return ResponseEntity.status(401).body("Please login first");

        List<Car> cart = getCartFromSession(session);
        if (cart.isEmpty()) return ResponseEntity.badRequest().body("Cart is empty");

        // Calculate Totals
        BigDecimal subTotal = BigDecimal.ZERO;
        for (Car car : cart) {
            subTotal = subTotal.add(car.getPrice());
        }

        BigDecimal taxRate = new BigDecimal("0.06");
        BigDecimal tax = subTotal.multiply(taxRate);

        // Shipping Logic (Overnight=$29, 3-Day=$19, Ground=$0)
        BigDecimal shippingFee = switch (request.shippingSpeed) {
            case "Overnight" -> new BigDecimal("29.00");
            case "3-Day" -> new BigDecimal("19.00");
            default -> BigDecimal.ZERO;
        };

        BigDecimal total = subTotal.add(tax).add(shippingFee);

        //Create the Order
        Order newOrder = new Order(
                user, subTotal, tax, shippingFee, total,
                request.street, request.city, request.state, request.zip,
                request.cardLastFour, request.phone
        );

        //Link Items & Mark Cars as SOLD
        List<OrderItem> orderItems = new ArrayList<>();
        for (Car cartItem : cart) {
            //Retrieve fresh car object to update status
            Car dbCar = carRepository.findById(cartItem.getCarID()).orElseThrow();

            //Double check it didn't get sold 1 second ago by someone else
            if (dbCar.isSold()) {
                return ResponseEntity.badRequest().body("So sorry! " + dbCar.getModel() + " was just sold.");
            }

            dbCar.setSold(true); //MARK AS SOLD
            carRepository.save(dbCar);

            //Create OrderItem
            orderItems.add(new OrderItem(dbCar, newOrder));
        }

        newOrder.setOrderItems(orderItems);
        orderRepository.save(newOrder);

        //Empty the Cart
        cart.clear();

        return ResponseEntity.ok(newOrder); // Return receipt
    }

    // ADMIN SALES REPORT
    @GetMapping("/admin/sales")
    public ResponseEntity<?> getSalesReport(HttpSession session) {
        User user = (User) session.getAttribute("user");

        // SECURITY CHECK
        if (user == null || !user.isAdministrator()) {
            return ResponseEntity.status(403).body("Access Denied: Admins Only");
        }

        // Return all orders
        return ResponseEntity.ok(orderRepository.findAllByOrderByOrderDateDesc());
    }

    // DTO for Checkout Data
    public record CheckoutRequest(
            String street, String city, String state, String zip,
            String cardLastFour, String phone, String shippingSpeed
    ) {}
}