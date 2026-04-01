package com.example.auroneqis.service.impl;

import com.example.auroneqis.dto.ContactMessageDTO;
import com.example.auroneqis.service.EmailService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender mailSender;

    @Value("${app.mail.admin}")
    private String adminEmail;

    public EmailServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendContactEmail(ContactMessageDTO dto) {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(adminEmail);

        message.setSubject("New Contact Form Submission");

        message.setText(
                "New Contact Message:\n\n" +
                "Name: " + dto.getName() + "\n" +
                "Email: " + dto.getEmail() + "\n" +
                "Service: " + dto.getService() + "\n\n" +
                "Message:\n" + dto.getMessage()
        );

        mailSender.send(message);
    }
}