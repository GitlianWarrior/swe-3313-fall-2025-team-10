package com.revline.rare_cars_sales;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthenticationController {

    @GetMapping("/")
    public String root() {
        // go straight to login when you hit http://localhost:8080
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLogin() {
        // just show login.html, let Spring Security handle POST /login
        return "login";
    }

    // ❌ DELETE the old @PostMapping("/login") method you had here

    @GetMapping("/register")
    public String showRegister() {
        return "register"; // register.html in templates
    }

    @PostMapping("/register")
    public String doRegister() {
        // later: save user, etc.
        return "redirect:/login";
    }
}
