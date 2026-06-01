package com.example.auroneqis.service.impl;

import com.example.auroneqis.dto.ProductContactMessageDTO;
import com.example.auroneqis.entity.ProductContactMessage;
import com.example.auroneqis.repository.ProductContactMessageRepository;
import com.example.auroneqis.service.ProductContactMessageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class ProductContactMessageServiceImpl implements ProductContactMessageService {

    private final ProductContactMessageRepository repository;
    private final JavaMailSender mailSender;

    @Value("${app.mail.admin}")
    private String adminEmail;

    public ProductContactMessageServiceImpl(ProductContactMessageRepository repository,
                                            JavaMailSender mailSender) {
        this.repository = repository;
        this.mailSender = mailSender;
    }

    @Override
    public void processProductContact(ProductContactMessageDTO dto) {

        // Save to DB
        ProductContactMessage entity = new ProductContactMessage();
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setProduct(dto.getProduct());
        entity.setMessage(dto.getMessage());

        repository.save(entity);

        // Send Email to Admin
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(adminEmail);
        message.setSubject("New Product Enquiry Form Submission");
        message.setText(
                "New Product Enquiry:\n\n" +
                "Name: " + dto.getName() + "\n" +
                "Email: " + dto.getEmail() + "\n" +
                "Phone Number: " + dto.getPhoneNumber() + "\n" +
                "Product: " + dto.getProduct() + "\n\n" +
                "Message:\n" + dto.getMessage()
        );

        mailSender.send(message);
    }
}