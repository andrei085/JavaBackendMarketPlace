package com.shop.marketplace.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Value("${spring.mail.username}")
    private String USERNAME;

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendMail(String toAddress, String subject,
                         String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(USERNAME);
        message.setTo(toAddress);
        message.setSubject(subject);
        message.setText(text);

        javaMailSender.send(message);
    }
}
