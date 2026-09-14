package com.example.infrastructure.adapter.in.web.controller;

import com.example.application.command.CreateTaskCommand;
import com.example.application.port.in.CreateTaskUseCase;
import com.example.application.port.in.GetTaskUseCase;
import com.example.application.port.in.ListTaskUseCase;
import com.example.domain.model.Task;
import com.example.infrastructure.adapter.in.web.request.CreateTaskRequest;
import com.example.infrastructure.adapter.in.web.response.TaskResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final CreateTaskUseCase createTaskUseCase;
    private final GetTaskUseCase getTaskUseCase;
    private final ListTaskUseCase listTaskUseCase;


    //............................... create ................................
    @PostMapping
    public ResponseEntity<TaskResponse> create(@Valid @RequestBody CreateTaskRequest request) {

        CreateTaskCommand command = new CreateTaskCommand(
                request.getTitle(),
                request.getDescription()
        );

        Task createdTask = createTaskUseCase.create(command);

        return ResponseEntity
                .created(URI.create("/api/v1/tasks/" + createdTask.id()))
                .body(TaskResponse.from(createdTask));
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<GetTaskResponse> getById(@PathVariable Long id) {
//
//        Task task = getTaskUseCase.getById(id);
//
//        GetTaskResponse response = new GetTaskResponse(
//                task.getId(),
//                task.getTitle(),
//                task.getDescription(),
//                task.getStatus(),
//                task.getCreatedAt(),
//                task.getCompletedAt()
//        );
//
//        return ResponseEntity.ok(response);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponse> getById(@PathVariable Long id) {
        Task task = getTaskUseCase.getById(id);

        return ResponseEntity.ok(TaskResponse.from(task));
    }

    //............................... listAll ................................
    @GetMapping
    public ResponseEntity<List<TaskResponse>> listAll() {
        List<TaskResponse> response = listTaskUseCase.listAll()
                .stream()
                .map(TaskResponse::from)
                .toList();

        return ResponseEntity.ok(response);
    }

}
