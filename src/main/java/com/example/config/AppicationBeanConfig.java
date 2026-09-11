package com.example.config;

import com.example.application.port.in.CreateTaskUseCase;
import com.example.application.port.out.TaskRepositoryPort;
import com.example.application.service.CreateTaskService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppicationBeanConfig {

    //............................... createGodUseCase ................................
    @Bean
    public CreateTaskUseCase createTaskUseCase(TaskRepositoryPort taskRepositoryPort) {
        return new CreateTaskService(taskRepositoryPort);
    }
}
