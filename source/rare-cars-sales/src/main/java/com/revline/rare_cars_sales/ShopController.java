package com.revline.rare_cars_sales;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ShopController {

    private final CarRepository carRepository;

    @Autowired
    public ShopController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    // SHOP PAGE
    @GetMapping("/shop")
    public String showShop(@RequestParam(value = "q", required = false) String query,
                           HttpSession session,
                           Model model) {

        // require login
        if (session.getAttribute("userId") == null) {
            return "redirect:/login";
        }

        List<Car> cars;
        if (query != null && !query.trim().isEmpty()) {
            cars = carRepository.searchAvailableCars(query.trim());
        } else {
            cars = carRepository.findByStatus("Available");
        }

        model.addAttribute("pageTitle", "Inventory");
        model.addAttribute("query", query);
        model.addAttribute("cars", cars);

        return "shop";
    }

    // CART PAGE
    @GetMapping("/cart")
    public String showCart(HttpSession session, Model model) {

        if (session.getAttribute("userId") == null) {
            return "redirect:/login";
        }

        @SuppressWarnings("unchecked")
        Map<Long, Integer> cart = (Map<Long, Integer>) session.getAttribute("cart");

        List<CartItem> items = new ArrayList<>();
        BigDecimal subtotal = BigDecimal.ZERO;

        if (cart != null && !cart.isEmpty()) {
            for (Map.Entry<Long, Integer> entry : cart.entrySet()) {
                Long carId = entry.getKey();
                int quantity = entry.getValue();

                carRepository.findById(carId).ifPresent(car -> {
                    BigDecimal price = BigDecimal.valueOf(car.getPrice());
                    BigDecimal lineTotal = price.multiply(BigDecimal.valueOf(quantity));
                    items.add(new CartItem(car, quantity, lineTotal));
                });
            }

            for (CartItem item : items) {
                subtotal = subtotal.add(item.getLineTotal());
            }
        }

        model.addAttribute("pageTitle", "Cart");
        model.addAttribute("items", items);
        model.addAttribute("subtotal", subtotal);

        return "cart";
    }

    // ADD TO CART
    @PostMapping("/cart/add/{id}")
    public String addToCart(@PathVariable Long id, HttpSession session) {

        if (session.getAttribute("userId") == null) {
            return "redirect:/login";
        }

        @SuppressWarnings("unchecked")
        Map<Long, Integer> cart = (Map<Long, Integer>) session.getAttribute("cart");
        if (cart == null) {
            cart = new HashMap<>();
        }

        cart.merge(id, 1, Integer::sum);  // increment quantity or set to 1
        session.setAttribute("cart", cart);

        return "redirect:/cart";
    }

    // REMOVE FROM CART
    @PostMapping("/cart/remove/{id}")
    public String removeFromCart(@PathVariable Long id, HttpSession session) {

        if (session.getAttribute("userId") == null) {
            return "redirect:/login";
        }

        @SuppressWarnings("unchecked")
        Map<Long, Integer> cart = (Map<Long, Integer>) session.getAttribute("cart");

        if (cart != null) {
            cart.remove(id);
            if (cart.isEmpty()) {
                session.removeAttribute("cart");
            } else {
                session.setAttribute("cart", cart);
            }
        }

        return "redirect:/cart";
    }

    // CHECKOUT PAGE
    @GetMapping("/checkout")
    public String showCheckout(HttpSession session, Model model) {

        if (session.getAttribute("userId") == null) {
            return "redirect:/login";
        }

        model.addAttribute("pageTitle", "Checkout");

        return "checkout";
    }
}
