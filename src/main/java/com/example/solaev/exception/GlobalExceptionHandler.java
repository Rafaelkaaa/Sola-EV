package com.example.solaev.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        return ResponseEntity.badRequest().body("Illegal argument: " + ex.getMessage());
    }
    @ExceptionHandler(NotFoundAddress.class)
    public ResponseEntity<String> handleIllegalArgumentException(NotFoundAddress ex) {
        return ResponseEntity.badRequest().body("Not found address" + ex.getMessage());
    }
}
