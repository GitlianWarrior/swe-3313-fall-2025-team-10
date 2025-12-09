package com.revline.rare_cars_sales;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class AuthenticationController {

    private final UserRepository userRepository;

    @Autowired
    public AuthenticationController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String root() {
        return "redirect:/login";
    }

    // LOGIN
    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(@RequestParam String username,
                          @RequestParam String password,
                          HttpSession session) {

        Optional<User> optionalUser = userRepository.findByUsername(username);

        if (optionalUser.isEmpty()) {
            return "redirect:/login?error";
        }

        User user = optionalUser.get();

        if (!user.getPassword().equals(password)) {
            return "redirect:/login?error";
        }

        session.setAttribute("userId", user.getUserID());
        session.setAttribute("username", user.getUsername());
        session.setAttribute("isAdmin", user.isAdministrator());

        if (user.isAdministrator()) {
            return "redirect:/sales-report";
        } else {
            return "redirect:/shop";
        }
    }

    // LOGOUT
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login?logout";
    }

    // REGISTER
    @GetMapping("/register")
    public String showRegister() {
        return "register";
    }

    @PostMapping("/register")
    public String doRegister(@RequestParam String username,
                             @RequestParam String password,
                             @RequestParam String confirmPassword,
                             @RequestParam String firstName,
                             @RequestParam String lastName,
                             @RequestParam String email,
                             Model model) {

        if (!password.equals(confirmPassword)) {
            model.addAttribute("error", "Passwords do not match.");
            return "register";
        }

        if (userRepository.findByUsername(username).isPresent()) {
            model.addAttribute("error", "Username already taken.");
            return "register";
        }

        User user = new User(username, password, firstName, lastName, email);
        user.setAdministrator(false);

        userRepository.save(user);

        return "redirect:/login?created";
    }
}