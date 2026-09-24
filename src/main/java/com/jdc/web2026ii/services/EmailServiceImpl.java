package com.jdc.web2026ii.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements  EmailService {

    @Autowired
    private JavaMailSender mailSender;
    @Override
    public void sendEmail(String[] toUser, String subject, String message){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        String emailUser = "dasecunempre@gmail.com";
        mailMessage.setFrom(emailUser);
        mailMessage.setTo(toUser);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);

        mailSender.send(mailMessage);

    }
}

