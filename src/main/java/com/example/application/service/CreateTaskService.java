package com.example.application.service;

import com.example.application.port.in.CreateTaskUseCase;
import com.example.application.port.out.TaskRepositoryPort;
import com.example.domain.model.Task;

/**
 * Servicio de aplicación encargado de coordinar el caso de uso de creación de una {@link Task}.
 *
 * <p>Depende únicamente de los puertos definidos por la capa de aplicación,
 * manteniendo desacoplada la lógica de negocio de las implementaciones concretas
 * utilizadas para la persistencia.</p>
 *
 * <p>Su responsabilidad es recibir la tarea que se desea crear, aplicar las validaciones
 * o reglas de negocio necesarias y delegar su persistencia en {@link TaskRepositoryPort}.</p>
 */
public class CreateTaskService implements CreateTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    //....................... Constructor .......................................
    public CreateTaskService(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    @Override
    public Task create(Task task) {
        return null;
    }
}
