package com.msbeigi.librarybackend.model;

public record UserRegisterRequest(String name, String email, String password, String imageUrl, String role) {}
