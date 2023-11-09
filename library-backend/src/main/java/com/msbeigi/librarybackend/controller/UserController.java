package com.msbeigi.librarybackend.controller;

import com.msbeigi.librarybackend.model.UserRegisterRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @PostMapping("/register")
    public ResponseEntity<?> registerNewUser(@RequestBody UserRegisterRequest request) {
        return null;
    }
}
