package com.example.infrastructure.adapter.out.persistence.adapter;

import com.example.application.port.out.TaskRepositoryPort;
import com.example.domain.model.Task;
import com.example.infrastructure.adapter.out.persistence.mapper.TaskMapper;
import com.example.infrastructure.adapter.out.persistence.entity.TaskEntity;
import com.example.infrastructure.adapter.out.persistence.repository.TaskJpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Implementación del puerto de salida {@link TaskRepositoryPort} definido por la capa de aplicación
 * y encargada de adaptar las operaciones de persistencia del dominio a la tecnología utilizada
 * por la infraestructura.
 *
 * <p>Delega las operaciones de acceso a datos en {@link TaskJpaRepository} y utiliza {@link TaskMapper}
 * para convertir entre el modelo de dominio {@link Task} y el modelo de persistencia {@link TaskEntity}.</p>
 */
@Repository
public class JpaTaskRepositoryAdapter implements TaskRepositoryPort {

    private final TaskJpaRepository repository;
    private final TaskMapper mapper;

    //......................... Constructor ...................................

    public JpaTaskRepositoryAdapter(TaskJpaRepository repository, TaskMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

//    @Override
//    public Task save(Task task) {
//        task.initDefaults();
//        TaskEntity entity = mapper.toEntity(task);
//        TaskEntity saved = repository.save(entity);
//
//        return mapper.toDomain(saved);
//    }

    @Override
    public Task save(Task task) {

        // 1. Convertimos el objeto de dominio en una entidad JPA
        TaskEntity taskEntity = mapper.toEntity(task);

        // 2. Delegamos la persistencia en el repositorio JPA
        TaskEntity savedEntity = repository.save(taskEntity);

        // 3. Convertimos la entidad persistida de nuevo al modelo de dominio
        Task savedDomain = mapper.toDomain(savedEntity);

        // 4. Devolvemos el objeto de dominio
        return savedDomain;
    }
}
