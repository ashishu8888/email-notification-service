package com.au.email_notification_service.Service.impl;

import com.au.email_notification_service.Entity.TaskNotification;
import com.au.email_notification_service.Service.EmailService;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
@Slf4j
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender javaMailSender;
    private final TemplateEngine templateEngine;

    @Autowired
    public EmailServiceImpl(JavaMailSender javaMailSender, TemplateEngine templateEngine) {
        this.javaMailSender = javaMailSender;
        this.templateEngine = templateEngine;
    }

    @Override
    public String sendSimpleEmail(String to, String subject, String body){
        try{
            SimpleMailMessage mail = new SimpleMailMessage();
            mail.setTo(to);
            mail.setSubject(subject);
            mail.setText(body);
            javaMailSender.send(mail);
        } catch(Exception e){
            log.error("Some error occurred while sending an email : {}",e.getMessage());
            return "fail";
        }

        return "pass";
    }

    @Override
    public String sendTemplatedEmail(TaskNotification taskNotification){
        try{
            Context context = new Context();
            context.setVariable("firstName", taskNotification.getFirstName());
            context.setVariable("lastName", taskNotification.getLastName());
            context.setVariable("taskTitle", taskNotification.getTask().getTitle());
            context.setVariable("taskBody", taskNotification.getTask().getBody());
            context.setVariable("dueDate", taskNotification.getTask().getDueDate());
            context.setVariable("subtasks", taskNotification.getTask().getSubtasks());

            String htmlContent = templateEngine.process("task-notification-email.html",context);

            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message,true);

            mimeMessageHelper.setTo("ishag1005@gmail.com");
            mimeMessageHelper.setSubject(taskNotification.getTask().getTitle());
            mimeMessageHelper.setText(htmlContent,true);

            javaMailSender.send(message);

            return "pass";

        } catch (Exception e){
            log.error("Error sending email: {}",e.getMessage());
            return "fail";
        }
    }


}
