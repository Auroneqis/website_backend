package com.example.auroneqis.controller;

import com.example.auroneqis.dto.ProductContactMessageDTO;
import com.example.auroneqis.service.ProductContactMessageService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product-contact")
@CrossOrigin()
public class ProductContactMessageController {

    private final ProductContactMessageService service;

    public ProductContactMessageController(ProductContactMessageService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> submit(@Valid @RequestBody ProductContactMessageDTO dto) {
        service.processProductContact(dto);
        return ResponseEntity.ok("Message sent successfully");
    }
}