package com.example.domain.model;

import java.time.LocalDateTime;

public final class Task {

    private final Long id;
    private final String title;
    private final String description;
    private TaskStatus status;
    private final LocalDateTime createdAt;
    private LocalDateTime completedAt;


    //............................... Constructor ................................
    private Task(
            Long id,
            String title,
            String description,
            TaskStatus status,
            LocalDateTime createdAt,
            LocalDateTime completedAt) {

        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Task title is required");
        }

        if (status == null) {
            throw new IllegalArgumentException("Task status is required");
        }

        if (createdAt == null) {
            throw new IllegalArgumentException("Task creation date is required");
        }

        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.createdAt = createdAt;
        this.completedAt = completedAt;
    }

    //............................... Reconstruir una Task existente ................................
    public static Task reconstitute(
            Long id,
            String title,
            String description,
            TaskStatus status,
            LocalDateTime createdAt,
            LocalDateTime completedAt) {

        if (id == null) {
            throw new IllegalArgumentException("Task id is required");
        }

        return new Task(
                id,
                title,
                description,
                status,
                createdAt,
                completedAt
        );
    }

    //............................... Crear una Task NUEVA ................................
    public static Task create(String title, String description) {
        return new Task(
                null,
                title,
                description,
                TaskStatus.PENDING,
                LocalDateTime.now(),
                null
        );
    }

    public void complete() {
        if (status == TaskStatus.COMPLETED) {
            throw new IllegalStateException("La tarea ya está completada");
        }

        status = TaskStatus.COMPLETED;
        completedAt = LocalDateTime.now();
    }

    public void reopen() {
        if (status == TaskStatus.PENDING) {
            throw new IllegalStateException("La tarea ya está pendiente");
        }

        status = TaskStatus.PENDING;
        completedAt = null;
    }

    public Long id() {
        return id;
    }

    public String title() {
        return title;
    }

    public String description() {
        return description;
    }

    public TaskStatus status() {
        return status;
    }

    public LocalDateTime createdAt() {
        return createdAt;
    }

    public LocalDateTime completedAt() {
        return completedAt;
    }

    //............................... equals / hashCode ................................
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Task other)) {
            return false;
        }

        if (id == null || other.id == null) {
            return false;
        }

        return id.equals(other.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

//@Getter
////@Setter
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//@EqualsAndHashCode(onlyExplicitlyIncluded = true)
//public class Task {
//
//    @EqualsAndHashCode.Include
//    private Long id;
//
//    private String title;
//    private String description;
//    private TaskStatus status;
//    private LocalDateTime createdAt;
//    private LocalDateTime completedAt;
//
//    public Task(String title, String description) {
//        this.title = title;
//        this.description = description;
//        this.status = TaskStatus.PENDING;
//        this.createdAt = LocalDateTime.now();
//    }
//
//    //............................... create ................................
//    public static Task create(String title, String description) {
//        Task task = Task.builder()
//                .title(title)
//                .description(description)
//                .build();
//
//        task.initDefaults();
//
//        return task;
//    }
//
//    //............................... complete ................................
//    public void complete(){
//        if(this.status == TaskStatus.COMPLETED){
//            throw new IllegalStateException("La tarea está completada");
//        }
//        this.status = TaskStatus.COMPLETED;
//        this.completedAt = LocalDateTime.now();
//    }
//
//    //............................... reopen ................................
//    public void reopen(){
//        if(this.status == TaskStatus.PENDING){
//            throw new IllegalStateException("La tarea ya está pendiente");
//        }
//        this.status = TaskStatus.PENDING;
//        this.completedAt = null;
//    }
//
//    //............................... initDefaults ................................
//    public void initDefaults(){
//        if(this.status == null)
//            this.status = TaskStatus.PENDING;
//        if(this.createdAt == null)
//            this.createdAt = LocalDateTime.now();
//    }
//}
