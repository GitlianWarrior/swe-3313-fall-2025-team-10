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
        return "login";   // login.html in templates
    }

    @PostMapping("/login")
    public String doLogin() {
        // later: add real auth logic
        return "redirect:/login";
    }

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
