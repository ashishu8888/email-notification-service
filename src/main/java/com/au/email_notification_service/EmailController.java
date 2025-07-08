package com.au.email_notification_service;

import com.au.email_notification_service.Dto.SimpleEmailDto;
import com.au.email_notification_service.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class EmailController {

    private final EmailService emailService;

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("notify/email")
    public ResponseEntity<String> sendSimpleEmail(@RequestBody SimpleEmailDto simpleEmailDto){
        return ResponseEntity.ok(emailService.sendSimpleEmail(simpleEmailDto.getTo(), simpleEmailDto.getSubject(), simpleEmailDto.getBody()));
    }
}
