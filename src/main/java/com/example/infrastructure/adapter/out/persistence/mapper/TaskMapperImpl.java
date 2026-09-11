package com.example.infrastructure.adapter.out.persistence.mapper;

import com.example.domain.model.Task;
import com.example.infrastructure.adapter.out.persistence.entity.TaskEntity;
import org.springframework.stereotype.Component;

/**
 * Evitamos usar MapStruct ya que a menudo requiere que las entidades tengan setters públicos o
 * constructores vacíos, lo que destruye el encapsulamiento del dominio (volviéndolo anémico).
 * Hacerlo manualmente nos da control total.
 */
@Component
public class TaskMapperImpl implements TaskMapper {

    @Override
    public Task toDomain(TaskEntity entity) {

        if (entity == null) {
            return null;
        }

        return Task.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .description(entity.getDescription())
                .status(entity.getStatus())
                .createdAt(entity.getCreatedAt())
                .completedAt(entity.getCompletedAt())
                .build();
    }

    @Override
    public TaskEntity toEntity(Task task) {

        if (task == null) {
            return null;
        }

        TaskEntity entity = new TaskEntity();

        entity.setId(task.getId());
        entity.setTitle(task.getTitle());
        entity.setDescription(task.getDescription());
        entity.setStatus(task.getStatus());
        entity.setCreatedAt(task.getCreatedAt());
        entity.setCompletedAt(task.getCompletedAt());

        return entity;
    }

}
