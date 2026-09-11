package com.example.domain.model;

import lombok.*;

import java.time.LocalDateTime;

@Getter
//@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Task {

    @EqualsAndHashCode.Include
    private Long id;

    private String title;
    private String description;
    private TaskStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime completedAt;

//    public Task(String title, String description) {
//        this.title = title;
//        this.description = description;
//        this.status = TaskStatus.PENDING;
//        this.createdAt = LocalDateTime.now();
//    }

    //............................... complete ................................
    public void complete(){
        if(this.status == TaskStatus.COMPLETED){
            throw new IllegalStateException("La tarea está completada");
        }
        this.status = TaskStatus.COMPLETED;
        this.completedAt = LocalDateTime.now();
    }

    //............................... reopen ................................
    public void reopen(){
        if(this.status == TaskStatus.PENDING){
            throw new IllegalStateException("La tarea ya está pendiente");
        }
        this.status = TaskStatus.PENDING;
        this.completedAt = null;
    }

    //............................... initDefaults ................................
    public void initDefaults(){
        if(this.status == null)
            this.status = TaskStatus.PENDING;
        if(this.createdAt == null)
            this.createdAt = LocalDateTime.now();
    }
}
