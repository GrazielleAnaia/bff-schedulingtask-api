package com.grazielleanaia.bff_schedulingtask_api.business.dto.out;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.grazielleanaia.bff_schedulingtask_api.infrastructure.enums.NotificationStatusEnum;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class TaskDTOResponse {

    private String id;

    private String customerEmail;

    private String taskName;

    private String description;

    private LocalDateTime creationDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy HH:mm:ss")
    private LocalDateTime eventDate;

    private LocalDateTime changeDate;

    private NotificationStatusEnum notificationStatusEnum;
}
