package com.example.config;

import com.example.application.port.in.CreateTaskUseCase;
import com.example.application.port.in.GetTaskUseCase;
import com.example.application.port.in.ListTaskUseCase;
import com.example.application.port.out.TaskRepositoryPort;
import com.example.application.service.CreateTaskService;
import com.example.application.service.GetTaskService;
import com.example.application.service.ListTaskService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationBeanConfig {

    //............................... createTaskUseCase ................................
    @Bean
    public CreateTaskUseCase createTaskUseCase(TaskRepositoryPort taskRepositoryPort) {
        return new CreateTaskService(taskRepositoryPort);
    }

    //............................... getTaskUseCase ................................
    @Bean
    public GetTaskUseCase getTaskUseCase(TaskRepositoryPort taskRepositoryPort) {
        return new GetTaskService(taskRepositoryPort);
    }

    //............................... listTaskUseCase ................................
    @Bean
    public ListTaskUseCase listTaskUseCase(TaskRepositoryPort taskRepositoryPort) {
        return new ListTaskService(taskRepositoryPort);
    }
}
