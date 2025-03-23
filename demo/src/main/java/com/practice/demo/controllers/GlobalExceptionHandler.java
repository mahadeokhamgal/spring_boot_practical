package com.practice.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.practice.demo.exeptions.ResourceNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND) // Set HTTP status as 404
    public ResponseEntity<String> handleResourceNotFound(ResourceNotFoundException ex) {
        String errorMessage = "Resource not found: " + ex.getMessage();
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // Set HTTP status as 500
    public ResponseEntity<String> handleGeneralException(Exception ex) {
        String errorMessage = "An unexpected error occurred: " + ex.getMessage();
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
