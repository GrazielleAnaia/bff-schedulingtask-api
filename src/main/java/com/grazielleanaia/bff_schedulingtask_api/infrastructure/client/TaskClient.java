package com.grazielleanaia.bff_schedulingtask_api.infrastructure.client;


import com.grazielleanaia.bff_schedulingtask_api.business.dto.TaskDTO;
import com.grazielleanaia.bff_schedulingtask_api.infrastructure.enums.NotificationStatusEnum;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@FeignClient(name = "task", url = "${task.url}")

public interface TaskClient {

    @PostMapping
    TaskDTO createTask(@RequestBody TaskDTO taskDTO,
                       @RequestHeader("Authorization") String token);

    @GetMapping
    List<TaskDTO> findTaskList(@RequestHeader("Authorization") String token);

    @GetMapping("/events")
    List<TaskDTO> findTaskByPeriod(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                   LocalDateTime initialDate,
                                   @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                   LocalDateTime finalDate,
                                   @RequestHeader("Authorization") String token);

    @DeleteMapping
    void deleteTaskById(@RequestParam("id") String id,
                        @RequestHeader("Authorization") String token);

    @PutMapping
    TaskDTO updateTasks(@RequestParam("id") String id,
                        @RequestBody TaskDTO taskDTO,
                        @RequestHeader("Authorization") String token);

    @PatchMapping
    TaskDTO changeNotificationStatus(@RequestParam("id") String id,
                                     @RequestParam("status") NotificationStatusEnum status,
                                     @RequestHeader("Authorization") String token);


}
