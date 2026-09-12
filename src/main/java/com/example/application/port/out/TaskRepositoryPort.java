package com.example.application.port.out;

import com.example.domain.model.Task;

import java.util.List;
import java.util.Optional;

/**
 * Representa las operaciones que necesita la aplicación para ejecutar los casos de uso relacionados
 * con {@link Task}.
 *
 * Define el contrato de salida que permite persistir y recuperar {@link Task}, manteniendo los servicios
 * de aplicación independientes de la implementación concreta del puerto
 * y de la tecnología de persistencia utilizada, ambas pertenecientes a infraestructura.
 */
public interface TaskRepositoryPort {

    Task save(Task task);
    Optional<Task> findById(Long id);
    List<Task> findAll();
}
