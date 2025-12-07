package com.revline.rare_cars_sales;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

@Controller
public class ShopController {

    @GetMapping("/shop")
    public String showShop(@RequestParam(value = "q", required = false) String query,
                           Model model) {

        model.addAttribute("pageTitle", "Inventory");
        model.addAttribute("query", query);
        model.addAttribute("cars", List.of()); // TODO: real cars later

        return "shop";
    }

    @GetMapping("/cart")
    public String showCart(Model model) {
        model.addAttribute("pageTitle", "Cart");
        model.addAttribute("items", Collections.emptyList());
        model.addAttribute("subtotal", BigDecimal.ZERO);

        return "cart";
    }

    @GetMapping("/checkout")
    public String showCheckout(Model model) {
        model.addAttribute("pageTitle", "Checkout");
        model.addAttribute("items", Collections.emptyList());
        model.addAttribute("subtotal", BigDecimal.ZERO);

        return "checkout";
    }

    @PostMapping("/cart/add/{id}")
    public String addToCart(@PathVariable Long id) {
        // TODO: add real cart logic
        return "redirect:/cart";
    }

    @PostMapping("/cart/remove/{id}")
    public String removeFromCart(@PathVariable Long id) {
        // TODO: remove from cart
        return "redirect:/cart";
    }
}
