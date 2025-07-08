package com.au.email_notification_service.Dto;

import com.au.email_notification_service.Enum.Priority;
import com.au.email_notification_service.Enum.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {

    private Integer id;

    private String title;

    private String body;

    private Priority priority;

    private Status status;

    private LocalDate dueDate;

    private LocalDate createdAt;

    private LocalDate updatedAt;

    private LocalDate completedAt;

    private List<SubtaskDto> subtasks = new ArrayList<>();

    private List<String> tags = new ArrayList<>();

    private List<String> attachments = new ArrayList<>();
}
