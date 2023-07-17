package com.benaya.assignments.clientapi.exception;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.MalformedURLException;
import java.time.LocalDateTime;


public class AppExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(MalformedURLException.class)
    public ProblemDetail handleIllegalArgumentException(BadUrlException e) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.UNPROCESSABLE_ENTITY, e.getMessage());
    }
    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        return new ResponseEntity<Object>(new ApiError("unhandled error: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, LocalDateTime.now()), HttpStatus.NOT_FOUND);
    }
}
