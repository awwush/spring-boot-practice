package com.codingshuttle.springbootpractice.module2.advices;

import com.codingshuttle.springbootpractice.module2.exception.DepartmentNotFoundException;
import com.codingshuttle.springbootpractice.module2.exception.PasswordInvalidException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionalHandler {

    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity handleDepartmentNotFound(DepartmentNotFoundException exp) {
        return new ResponseEntity(exp.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PasswordInvalidException.class)
    public ResponseEntity handleInvalidPassword(PasswordInvalidException exp) {
        return new ResponseEntity(exp.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
