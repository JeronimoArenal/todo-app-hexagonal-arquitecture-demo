package com.example.application.service;

import com.example.application.port.in.CreateTaskUseCase;
import com.example.application.port.out.TaskRepositoryPort;
import com.example.domain.model.Task;

public class CreateTaskService implements CreateTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    public CreateTaskService(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    @Override
    public Task create(Task task) {
        return taskRepositoryPort.save(task);
    }
}
