package com.example.application.port.in;

import com.example.domain.model.Task;

import java.util.List;

public interface ListTaskUseCase {

    List<Task> listAll();
}
