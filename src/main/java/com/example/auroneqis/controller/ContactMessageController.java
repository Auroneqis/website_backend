package com.example.auroneqis.controller;

import com.example.auroneqis.dto.ContactMessageDTO;
import com.example.auroneqis.service.ContactMessageService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin()
public class ContactMessageController {

    private final ContactMessageService service;

    public ContactMessageController(ContactMessageService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> submit(@Valid @RequestBody ContactMessageDTO dto) {

        service.processContact(dto);

        return ResponseEntity.ok("Message sent successfully");
    }
}
