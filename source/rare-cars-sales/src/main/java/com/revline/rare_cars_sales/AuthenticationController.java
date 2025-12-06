package com.revline.rare_cars_sales;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthenticationController {

    @GetMapping("/login")
    public String login() {
        return "login"; // Matches login.html in templates folder
    }
}