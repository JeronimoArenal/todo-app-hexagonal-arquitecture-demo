package com.example.infrastructure.adapter.in.web.controller;

import com.example.application.port.in.CreateTaskUseCase;
import com.example.domain.model.Task;
import com.example.infrastructure.adapter.in.web.request.CreateTaskRequest;
import com.example.infrastructure.adapter.in.web.response.TaskResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final CreateTaskUseCase createTaskUseCase;

    //............................... create ................................
    @PostMapping
    public ResponseEntity<TaskResponse> create(@Valid @RequestBody CreateTaskRequest request) {

        Task task = Task.create(
                request.getTitle(),
                request.getDescription()
        );

        Task createdTask = createTaskUseCase.create(task);

        return ResponseEntity
                .created(URI.create("/api/v1/tasks/" + createdTask.getId()))
                .body(TaskResponse.from(createdTask));
    }

}
