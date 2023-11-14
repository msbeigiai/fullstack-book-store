package com.msbeigi.librarybackend.config;

import com.msbeigi.librarybackend.entity.Authority;
import com.msbeigi.librarybackend.entity.User;
import com.msbeigi.librarybackend.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
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
                    username, password, getGrantedAuthorities(user.getAuthorities()));
        } else throw new BadCredentialsException("Invalid password. No user registered with this email");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class).isAssignableFrom(authentication);
    }

    public List<GrantedAuthority> getGrantedAuthorities(Set<Authority> authorities) {
        return authorities.stream().map(a ->
                new SimpleGrantedAuthority(a.getName())).collect(Collectors.toList());
    }
}
