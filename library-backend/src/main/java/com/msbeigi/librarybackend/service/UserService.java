package com.msbeigi.librarybackend.service;

import com.msbeigi.librarybackend.entity.User;
import com.msbeigi.librarybackend.model.UserRegisterRequest;

public interface UserService {
    User findUserByEmail(String email);

    void registerUser(UserRegisterRequest request);
}
