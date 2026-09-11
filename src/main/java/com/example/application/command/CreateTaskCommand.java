package com.example.application.command;

public record CreateTaskCommand(
        String title,
        String description)  {
}
