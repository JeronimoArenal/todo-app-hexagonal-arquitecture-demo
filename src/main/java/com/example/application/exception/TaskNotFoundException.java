package com.example.application.exception;

/**
 * Permite diferenciar los errores funcionales de la aplicación de las excepciones técnicas de infraestructura.
 * Expresa un problema funcional conocido por el caso de uso.
 */
public class TaskNotFoundException extends RuntimeException {

    /**
     * TaskNotFoundException es una regla de negocio y se puede utilizar en este contexto
     */
    public TaskNotFoundException(Long id) {
        super("No ha sido encontrada la tarea con id:" + id);
    }
}
