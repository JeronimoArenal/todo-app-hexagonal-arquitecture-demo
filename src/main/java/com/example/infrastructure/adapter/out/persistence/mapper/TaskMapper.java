package com.example.infrastructure.adapter.out.persistence.mapper;

import com.example.domain.model.Task;
import com.example.infrastructure.adapter.out.persistence.entity.TaskEntity;

/**
 * Responsable de separar Dominio de Persistencia, de esta manera, la entidad JPA
 * no se expone directamente al dominio.
 * Permiten realizar conversiones en ambos sentidos.
 */
//@Mapper(componentModel = "spring")
public interface TaskMapper {
    TaskEntity toEntity(Task task);

    Task toDomain(TaskEntity entity);
}
