package com.au.email_notification_service.PubSubUtil;

import com.au.email_notification_service.Constant.RmqConstant;
import com.au.email_notification_service.Entity.TaskNotification;
import com.au.email_notification_service.Service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RmqConsumerUtil {

    private final EmailService emailService;

    public RmqConsumerUtil(EmailService emailService) {
        this.emailService = emailService;
    }

    @RabbitListener(queues = RmqConstant.QUEUE_NAME)
    public void consumeTodayTasks(TaskNotification taskNotification) {
        log.info("🔔 Received Task Notification for: {}", taskNotification.getEmail());
        log.info("🔔 Received Task Notification for: {}", taskNotification.getTask().getId());
        log.info("📌 Task: {}", taskNotification.getTask().getTitle());

        emailService.sendTemplatedEmail(taskNotification);
    }
}
