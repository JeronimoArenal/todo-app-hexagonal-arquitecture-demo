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

        return Task.reconstitute(
                entity.getId(),
                entity.getTitle(),
                entity.getDescription(),
                entity.getStatus(),
                entity.getCreatedAt(),
                entity.getCompletedAt()
        );
    }

    @Override
    public TaskEntity toEntity(Task task) {

        if (task == null) {
            return null;
        }

        TaskEntity entity = new TaskEntity();

        entity.setId(task.id());
        entity.setTitle(task.title());
        entity.setDescription(task.description());
        entity.setStatus(task.status());
        entity.setCreatedAt(task.createdAt());
        entity.setCompletedAt(task.completedAt());

        return entity;
    }
}
