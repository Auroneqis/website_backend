package com.example.auroneqis.service;

import com.example.auroneqis.dto.ContactMessageDTO;

public interface EmailService {
    void sendContactEmail(ContactMessageDTO dto);
}