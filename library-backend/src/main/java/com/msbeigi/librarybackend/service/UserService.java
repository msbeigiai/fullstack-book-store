package com.msbeigi.librarybackend.service;

import com.msbeigi.librarybackend.entity.User;

public interface UserService {
    User findUserByEmail(String email);
}
