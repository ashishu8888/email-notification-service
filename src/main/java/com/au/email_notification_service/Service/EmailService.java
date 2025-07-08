package com.au.email_notification_service.Service;

import com.au.email_notification_service.Entity.TaskNotification;

public interface EmailService {
    String sendSimpleEmail(String to, String subject, String body);

    String sendTemplatedEmail(TaskNotification taskNotification);
}
