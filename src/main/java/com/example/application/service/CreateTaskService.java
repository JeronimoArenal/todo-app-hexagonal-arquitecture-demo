package com.example.application.service;

import com.example.application.command.CreateTaskCommand;
import com.example.application.port.in.CreateTaskUseCase;
import com.example.application.port.out.TaskRepositoryPort;
import com.example.domain.model.Task;

public class CreateTaskService implements CreateTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    //............................... Constructor ................................
    public CreateTaskService(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

//    @Override
//    public Task create(Task task) {
//        return taskRepositoryPort.save(task);
//    }

    @Override
    public Task create(CreateTaskCommand command) {
        Task task = Task.create(command.title(), command.description());

        return taskRepositoryPort.save(task);
    }
}
