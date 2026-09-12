package com.example.application.service;

import com.example.application.port.in.GetTaskUseCase;
import com.example.application.port.out.TaskRepositoryPort;
import com.example.application.exception.TaskNotFoundException;
import com.example.domain.model.Task;

public class GetTaskService implements GetTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    //............................... Constructor ................................
    public GetTaskService(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    @Override
    public Task getById(Long id) {
        return taskRepositoryPort.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
    }
}
