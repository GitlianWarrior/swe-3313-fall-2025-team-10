package com.revline.rare_cars_sales;

import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    private final UserRepository userRepository;

    public AuthenticationController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //REGISTER
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User newUser) {
        //Check if username already exists
        if (userRepository.findByUsername(newUser.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("Username already taken");
        }

        // Enforce 6-character password minimum
        if (newUser.getPassword() == null || newUser.getPassword().length() < 6) {
            return ResponseEntity.badRequest().body("Password must be at least 6 characters");
        }

        //Save the new user
        User savedUser = userRepository.save(newUser);
        return ResponseEntity.ok(savedUser);
    }

    // LOGIN
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest, HttpSession session) {
        //Find user by username
        Optional<User> userOptional = userRepository.findByUsername(loginRequest.username());

        //Check if user exists and password matches
        if (userOptional.isPresent() && userOptional.get().getPassword().equals(loginRequest.password())) {
            User user = userOptional.get();

            //Save user to Session
            session.setAttribute("user", user);

            return ResponseEntity.ok(user);
        }

        return ResponseEntity.status(401).body("Invalid Username or Password");
    }

    // LOGOUT
    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpSession session) {
        session.invalidate();
        return ResponseEntity.ok("Logged out successfully");
    }

    // CHECK SESSION
    @GetMapping("/me")
    public ResponseEntity<?> getCurrentUser(HttpSession session) {
        User currentUser = (User) session.getAttribute("user");
        if (currentUser == null) {
            return ResponseEntity.status(401).body("Not logged in");
        }
        return ResponseEntity.ok(currentUser);
    }

    // Simple DTO for Login
    public record LoginRequest(String username, String password) {}
}