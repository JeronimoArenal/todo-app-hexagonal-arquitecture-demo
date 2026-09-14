package com.example.infrastructure.adapter.in.web.advice;

import com.example.application.exception.TaskNotFoundException;
import com.example.infrastructure.adapter.in.web.response.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Se registra automáticamente gracias a @RestControllerAdvice.
 * El Service lanza la exception, y aquí hacemos la traducción.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TaskNotFoundException.class)
    public ProblemDetail handleTaskNotFound(TaskNotFoundException ex) {

        ProblemDetail problem = ProblemDetail.forStatusAndDetail(
                HttpStatus.NOT_FOUND,
                ex.getMessage()
        );

        problem.setTitle("Tarea no encontrada");
        problem.setProperty("errorCode", "TASK_NOT_FOUND");

        return problem;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleValidationErrors(
            MethodArgumentNotValidException ex) {

        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error ->
                        error.getField() + ": " + error.getDefaultMessage()
                )
                .toList();

        ProblemDetail problem = ProblemDetail.forStatusAndDetail(
                HttpStatus.BAD_REQUEST,
                "Se han producido errores de validación"
        );

        problem.setTitle("Datos inválidos");
        problem.setProperty("errorCode", "VALIDATION_ERROR");
        problem.setProperty("errors", errors);

        return problem;
    }

//    @ExceptionHandler(TaskNotFoundException.class)
//    public ResponseEntity<ErrorResponse> handleTaskNotFound(
//            TaskNotFoundException ex,
//            HttpServletRequest request) {
//
//        ErrorResponse response = new ErrorResponse(
//                LocalDateTime.now(),
//                HttpStatus.NOT_FOUND.value(),
//                "Not Found",
//                ex.getMessage(),
//                request.getRequestURI()
//        );
//
//        return ResponseEntity
//                .status(HttpStatus.NOT_FOUND)
//                .body(response);
//    }
}
