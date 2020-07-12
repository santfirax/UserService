package com.smolano.createuser.utils;

import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

public class ApiError {
    private HttpStatus httpStatus;
    private String message;
    private List<String> errors;

    public ApiError(HttpStatus httpStatus, String message, List<String> errors) {
        this.httpStatus = httpStatus;
        this.message = message;
        this.errors = errors;
    }

    public ApiError(HttpStatus httpStatus, String message, String... errors) {
        this.httpStatus = httpStatus;
        this.message = message;
        this.errors = Arrays.asList(errors);
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public List<String> getErrors() {
        return errors;
    }

    @Override
    public String toString() {
        return "ApiError{" +
                "httpStatus=" + httpStatus +
                ", message='" + message + '\'' +
                ", errors=" + errors +
                '}';
    }
}
