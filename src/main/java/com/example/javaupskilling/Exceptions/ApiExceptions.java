package com.example.javaupskilling.Exceptions;

import org.springframework.http.HttpStatus;

public class ApiExceptions {

    private final String message;
    private final Throwable throwable;
    private final HttpStatus httpStatus;


    public ApiExceptions(String message, Throwable throwable, HttpStatus httpStatus) {
        this.message = message;
        this.throwable = throwable;
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
