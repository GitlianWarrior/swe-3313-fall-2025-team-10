package com.revline.rare_cars_sales;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrderController {

    @GetMapping("/shipping-info")
    public String showShippingInfo() {
        return "shipping-info";
    }

    @PostMapping("/shipping-info")
    public String submitShippingInfo() {
        // later: collect form data, save in session
        return "redirect:/order-summary";
    }

    @GetMapping("/order-summary")
    public String showOrderSummary(Model model) {
        // sample data
        model.addAttribute("subtotal", 9900);
        model.addAttribute("tax", 594);
        model.addAttribute("shipping", 29);
        model.addAttribute("total", 10523);
        return "order-summary";
    }

    @PostMapping("/complete-order")
    public String completeOrder() {
        return "redirect:/receipt";
    }

    @GetMapping("/receipt")
    public String showReceipt(Model model) {
        model.addAttribute("address", "123 Joe Rogan Rd, Atlanta, GA, 30000");
        model.addAttribute("subtotal", 9900);
        model.addAttribute("tax", 594);
        model.addAttribute("shipping", 29);
        model.addAttribute("total", 10523);
        model.addAttribute("lastFour", "0112");
        return "receipt";
    }

    @GetMapping("/sales-report")
    public String showSalesReport() {
        return "sales-report";
    }
}
