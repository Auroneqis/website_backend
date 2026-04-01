package com.example.auroneqis.dto;


import com.example.auroneqis.enums.ServiceType;
import jakarta.validation.constraints.*;

public class ContactMessageDTO {

    @NotBlank
    private String name;

    @Email
    @NotBlank
    private String email;

    @NotNull(message = "Please select a service")
    private ServiceType service;

    @NotBlank
    private String message;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ServiceType getService() {
		return service;
	}

	public void setService(ServiceType service) {
		this.service = service;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

    
}
