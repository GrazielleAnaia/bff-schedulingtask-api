package com.grazielleanaia.bff_schedulingtask_api.business.dto.in;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.grazielleanaia.bff_schedulingtask_api.infrastructure.enums.NotificationStatusEnum;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class TaskDTORequest {

    private String id;

    private String taskName;

    private String description;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy HH:mm:ss")
    private LocalDateTime eventDate;


}
