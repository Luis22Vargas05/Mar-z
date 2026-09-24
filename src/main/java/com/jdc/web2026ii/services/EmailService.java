package com.jdc.web2026ii.services;

public interface EmailService {
    void sendEmail(String[] toUser, String subject, String message);
}
