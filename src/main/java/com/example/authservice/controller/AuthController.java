package com.example.authservice.controller;

import com.example.authservice.model.User;
import com.example.authservice.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return authService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        Optional<User> authenticatedUser = authService.authenticate(user.getUsername(), user.getPassword());
        return authenticatedUser.isPresent() ? "Login Successful" : "Invalid Credentials";
    }
}
