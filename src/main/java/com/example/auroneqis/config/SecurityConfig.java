package com.example.auroneqis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

    http
        .csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(auth -> auth

            .requestMatchers("/blog-images/**").permitAll()

            .requestMatchers("/api/contact").permitAll()
            .requestMatchers("/api/admin/blog/create").permitAll()
            .requestMatchers("/api/admin/blogs").permitAll()
            .requestMatchers("/api/admin/blog/delete/**").permitAll()
            .requestMatchers("/api/admin/blog/update/**").permitAll()
            .requestMatchers("/api/blog/like/**").permitAll()
            .requestMatchers("/api/blog/id/**").permitAll()
            .requestMatchers("/api/blog/**").permitAll()

            .anyRequest().authenticated()
        );

    return http.build();
}
}