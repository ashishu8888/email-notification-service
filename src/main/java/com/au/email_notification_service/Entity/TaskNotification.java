package com.au.email_notification_service.Entity;

import com.au.email_notification_service.Dto.TaskDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskNotification {
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate date;
    private TaskDto task;
}
