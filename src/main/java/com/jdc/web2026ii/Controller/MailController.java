package com.jdc.web2026ii.Controller;

import com.jdc.web2026ii.DTO.EmailDTO;
import com.jdc.web2026ii.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
    @RequestMapping("/v1")
    public class MailController {
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private EmailService emailService;

    @PostMapping("/sendMessage")
    public ResponseEntity<?> receiveMessage(@RequestBody EmailDTO emailDTO) {
        System.out.println("Mensaje Enviado:" + emailDTO);
        emailService.sendEmail(emailDTO.getToUser(), emailDTO.getSubjet(), emailDTO.getMessage());
        Map<String, String> map = new HashMap<>();
        map.put("status", "OK");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}


