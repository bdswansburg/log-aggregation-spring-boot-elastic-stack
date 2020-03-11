package com.cassiomolin.logaggregation.post.web.controller;

import com.cassiomolin.logaggregation.post.web.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;


@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex, ServletWebRequest servletWebRequest) {
        log.error("Received exception", ex);
        ErrorResponse errorResponse = ErrorResponse.builder().statusCode("404").message(ex.getMessage()).build();
        ResponseEntity<ErrorResponse> responseEntity = new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        return responseEntity;
    }


    @ExceptionHandler(Throwable.class)
    public ResponseEntity<ErrorResponse> handleThrowable(Throwable ex, ServletWebRequest servletWebRequest) {
        log.error("Received exception", ex);
        ErrorResponse errorResponse = ErrorResponse.builder().statusCode("404").message(ex.getMessage()).build();
        ResponseEntity<ErrorResponse> responseEntity = new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        return responseEntity;
    }
}
