package com.au.email_notification_service.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubtaskDto {

    private Integer id;

    private String title;

    private boolean completed;

    private Integer parentTaskId;
}
