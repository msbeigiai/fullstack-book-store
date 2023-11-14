package com.msbeigi.librarybackend.service.impl;

import com.msbeigi.librarybackend.entity.User;
import com.msbeigi.librarybackend.model.UserRegisterRequest;
import com.msbeigi.librarybackend.repository.UserRepository;
import com.msbeigi.librarybackend.service.UserService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmailIgnoreCase(email)
                .orElseThrow(() -> new UsernameNotFoundException("User with email %s not found.".formatted(email)));
    }

    @Override
    public void registerUser(UserRegisterRequest request) {
        if (userRepository.existsByEmailIgnoreCase(request.email())) {
            throw new RuntimeException("User with email already exists");
        }
        User user = new User(
                request.name(),
                request.email(),
                passwordEncoder.encode(request.password()),
                request.imageUrl(),
                true,
                request.role()
        );

        userRepository.save(user);
    }
}
