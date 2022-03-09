package com.bideafactory.bookingservices.config;

import com.bideafactory.bookingservices.config.exception.BadRequestException;
import com.bideafactory.bookingservices.config.exception.ConflictException;
import com.bideafactory.bookingservices.config.exception.NotFoundException;
import com.bideafactory.bookingservices.model.response.ErrorResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class ExceptionConfig {

    ErrorResponse errorResponse;
    
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFoundException(Exception e){
        errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), "Error", e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> badRequestException(Exception e){
        errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "Error", e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<?> conflictException(Exception e){
        errorResponse = new ErrorResponse(HttpStatus.CONFLICT.value(), "Conflict", e.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<?> nullPointerException(Exception e){
        errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "Error", e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}
