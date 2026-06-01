package com.example.auroneqis.dto;

import com.example.auroneqis.enums.ProductType;
import jakarta.validation.constraints.*;

public class ProductContactMessageDTO {

    @NotBlank
    private String name;

    @Email
    @NotBlank
    private String email;

    @NotNull(message = "Please select a product")
    private ProductType product;

    private String phoneNumber;

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

    public ProductType getProduct() {
        return product;
    }

    public void setProduct(ProductType product) {
        this.product = product;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}