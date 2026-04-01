package com.example.auroneqis.service.impl;

import com.example.auroneqis.dto.ContactMessageDTO;
import com.example.auroneqis.entity.ContactMessage;
import com.example.auroneqis.repository.ContactMessageRepository;
import com.example.auroneqis.service.ContactMessageService;
import com.example.auroneqis.service.EmailService;
import org.springframework.stereotype.Service;

@Service
public class ContactMessageServiceImpl implements ContactMessageService {

    private final ContactMessageRepository repository;
    private final EmailService emailService;

    public ContactMessageServiceImpl(ContactMessageRepository repository,
                                     EmailService emailService) {
        this.repository = repository;
        this.emailService = emailService;
    }

    @Override
    public void processContact(ContactMessageDTO dto) {

        // Save to DB
        ContactMessage entity = new ContactMessage();
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setService(dto.getService());
        entity.setMessage(dto.getMessage());

        repository.save(entity);

        // Send Email to Admin
        emailService.sendContactEmail(dto);
    }
}
