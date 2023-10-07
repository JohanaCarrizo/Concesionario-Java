package com.project.coches.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllersExceptions {
    @ExceptionHandler({CustomerExistsException.class, CustomerNotExistException.class, PasswordIncorrectException.class, EmailValidationException.class, PurchaseNotExistException.class})
    public ProblemDetail badRequestException(RuntimeException runtimeException){
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, runtimeException.getMessage());
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ProblemDetail accessDeniedException(AccessDeniedException accessDeniedException) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.UNAUTHORIZED, accessDeniedException.getMessage());
    }
}
