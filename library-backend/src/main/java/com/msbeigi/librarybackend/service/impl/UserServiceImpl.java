package com.msbeigi.librarybackend.service.impl;

import com.msbeigi.librarybackend.entity.User;
import com.msbeigi.librarybackend.repository.UserRepository;
import com.msbeigi.librarybackend.service.UserService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmailIgnoreCase(email)
                .orElseThrow(() -> new UsernameNotFoundException("User with email %s not found.".formatted(email)));
    }
}
