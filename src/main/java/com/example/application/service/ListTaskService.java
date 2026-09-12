package com.example.application.service;

import com.example.application.port.in.ListTaskUseCase;
import com.example.application.port.out.TaskRepositoryPort;
import com.example.domain.model.Task;

import java.util.List;

public class ListTaskService implements ListTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    //............................... Constructor ................................
    public ListTaskService(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    @Override
    public List<Task> listAll() {
        return taskRepositoryPort.findAll();
    }
}

