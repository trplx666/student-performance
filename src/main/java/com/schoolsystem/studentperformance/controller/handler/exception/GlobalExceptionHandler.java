package com.schoolsystem.studentperformance.controller.handler.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException exception) {
        Map<String, String> errorsMap = new HashMap<>();
        getErrorsAndPutInMap(exception, errorsMap);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorsMap);
    }

    private Map<String, String> getErrorsAndPutInMap(MethodArgumentNotValidException exception, Map<String,String> errors) {
        exception.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));
        return errors;
    }
}
