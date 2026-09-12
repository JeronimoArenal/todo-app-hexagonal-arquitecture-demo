package com.example.infrastructure.adapter.in.web.response;

import com.example.domain.model.Task;
import com.example.domain.model.TaskStatus;

import java.time.LocalDateTime;

public record TaskResponse(
        Long id,
        String title,
        String description,
        TaskStatus status,
        LocalDateTime createdAt,
        LocalDateTime completedAt) {

    public static TaskResponse from(Task task) {
        return new TaskResponse(
                task.id(),
                task.title(),
                task.description(),
                task.status(),
                task.createdAt(),
                task.completedAt());
    }
}
