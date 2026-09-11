package com.example.application.port.in;

import com.example.domain.model.Task;

/**
 * Define un caso de uso expuesto por la capa de aplicación.
 *
 * Los Input Ports representan las operaciones que la capa de aplicación expone
 * hacia el exterior como casos de uso.
 *
 * Los adaptadores de entrada (por ejemplo, Controllers) invocan estos puertos
 * para ejecutar los casos de uso de la aplicación.
 */
public interface CreateTaskUseCase {

    Task create(Task task);

}
