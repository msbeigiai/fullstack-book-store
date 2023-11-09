package com.msbeigi.librarybackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityFilterChain {

    private static final String GLOBAL_URI = "/api/v1";

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(Customizer.withDefaults())
                .authorizeHttpRequests((requests) -> requests
                        .antMatchers(HttpMethod.GET, GLOBAL_URI + "/categories").permitAll()
                        .antMatchers(GLOBAL_URI + "/register").permitAll()
                        .anyRequest()
                        .authenticated());
        return http.build();
    }


}
    /*.antMatchers(HttpMethod.GET, GLOBAL_URI + "/books/**")
                        .permitAll()*/