package com.example.sprinInAction.ErrorHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handlingArgumentException(MethodArgumentNotValidException ex){
        return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);

    }
}
