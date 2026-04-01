package com.example.auroneqis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@SpringBootApplication
@Configuration
@EnableMethodSecurity
public class AuroneqisApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuroneqisApplication.class, args);
	}

}
