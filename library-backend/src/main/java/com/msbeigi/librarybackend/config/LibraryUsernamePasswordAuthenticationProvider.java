package com.msbeigi.librarybackend.config;

import com.msbeigi.librarybackend.entity.User;
import com.msbeigi.librarybackend.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

public class LibraryUsernamePasswordAuthenticationProvider implements AuthenticationProvider {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public LibraryUsernamePasswordAuthenticationProvider(
            UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        User user = userRepository.findByEmailIgnoreCase(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User with email %s not found!".formatted(username)));
        if (passwordEncoder.matches(password, user.getPassword())) {
            return new UsernamePasswordAuthenticationToken(
                    username, password, List.of(new SimpleGrantedAuthority(user.getRole())));
        } else throw new BadCredentialsException("Invalid password. No user registered with this email");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class).isAssignableFrom(authentication);
    }
}
