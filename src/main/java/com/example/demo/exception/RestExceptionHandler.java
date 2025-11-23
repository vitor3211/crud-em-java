package com.example.demo.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<Object> handleEmailAlreadyExistsException(UserAlreadyExistsException exception, HttpServletRequest request){
        ErrorResponse errorResponse = new ErrorResponse(
            LocalDateTime.now(),
            exception.getMessage(),
            exception.getCause(),
            HttpStatus.CONFLICT,
            request.getRequestURI()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

}
