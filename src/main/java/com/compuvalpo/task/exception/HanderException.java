package com.compuvalpo.task.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class HanderException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ProblemDetail handerValidation(MethodArgumentNotValidException exception){
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);

        List<String> errors = new ArrayList<>();
        List<FieldError> fieldErrors = exception.getFieldErrors();

        for(FieldError fe : fieldErrors) {
            errors.add(fe.getDefaultMessage());
        }
        problemDetail.setProperty("message", "Solicitud no superó la revisión.");
        problemDetail.setProperty("errors", errors);

        return problemDetail;
    }
}
