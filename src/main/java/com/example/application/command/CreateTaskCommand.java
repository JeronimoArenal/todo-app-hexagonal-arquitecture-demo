package com.example.application.command;

/**
 * Objeto inmutable para transportar datos hacia el UseCase
 */
public record CreateTaskCommand(
        String title,
        String description)  {
}
