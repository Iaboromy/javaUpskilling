package com.example.javaupskilling.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ApiExceptionHandler extends RuntimeException{

    public ResponseEntity<Object> ApiExceptionHandler(ApiRequestException e) {
        ApiExceptions apiExceptions = new ApiExceptions(
                e.getMessage(),
                e,
                HttpStatus.BAD_REQUEST
        );
        return  new ResponseEntity<Object>(apiExceptions,HttpStatus.BAD_REQUEST);

    }

}
