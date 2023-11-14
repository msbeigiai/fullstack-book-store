package com.msbeigi.librarybackend.controller;

import com.msbeigi.librarybackend.entity.Authority;
import com.msbeigi.librarybackend.entity.User;
import com.msbeigi.librarybackend.model.Roles;
import com.msbeigi.librarybackend.model.UserRegisterRequest;
import com.msbeigi.librarybackend.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerNewUser(@RequestBody UserRegisterRequest request) {
        userService.registerUser(request);
        return ResponseEntity.created(URI.create(""))
                .body("User with email %s has been successfully registered!".formatted(request.email()));
    }

    @GetMapping("/user")
    public User getUser(Authority authority) {
        return userService.findUserByEmail(authority.getName());
    }
}
