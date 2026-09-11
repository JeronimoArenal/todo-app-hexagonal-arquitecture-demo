package com.example.infrastructure.adapter.out.persistence.repository;

import com.example.application.port.out.TaskRepositoryPort;
import com.example.infrastructure.adapter.out.persistence.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio de persistencia basado en Spring Data JPA para {@link TaskEntity}.
 *
 * <p>Las operaciones de persistencia estándar son proporcionadas automáticamente por {@link JpaRepository}.
 * Además, define las consultas específicas necesarias para relacionar las Task.</p>
 *
 * <p>Este repositorio pertenece a la infraestructura de persistencia y permanece oculto
 * para las capas de aplicación y dominio, que acceden a los datos mediante el puerto de salida
 * {@link TaskRepositoryPort} y su correspondiente adaptador.</p>
 */
public interface TaskJpaRepository extends JpaRepository<TaskEntity, Long> {
}
