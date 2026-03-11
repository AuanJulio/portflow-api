package com.portflow.infra.exceptions;

import com.portflow.core.exceptions.DuplicatedContainerException;
import com.portflow.core.exceptions.RegisterNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(DuplicatedContainerException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public StandardError handleDuplicatedContainerException(DuplicatedContainerException exception,
                                                                            HttpServletRequest request) {
        return StandardError.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.CONFLICT.value())
                .error(HttpStatus.CONFLICT.getReasonPhrase())
                .path(request.getRequestURI())
                .message(exception.getMessage())
                .errors(null)
                .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public StandardError handleArgumentNotValidException(MethodArgumentNotValidException exception,
                                                         HttpServletRequest request) {
        Map<String, String> errors = new HashMap<>();
        exception.getBindingResult().getFieldErrors()
                .forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));

        return StandardError.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .error(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .path(request.getRequestURI())
                .message(exception.getMessage())
                .errors(errors)
                .build();
    }

    @ExceptionHandler(RegisterNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public StandardError handleRegisterNotFoundException(RegisterNotFoundException exception,
                                                         HttpServletRequest request) {
        return StandardError.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.NOT_FOUND.value())
                .error(HttpStatus.NOT_FOUND.getReasonPhrase())
                .path(request.getRequestURI())
                .message(exception.getMessage())
                .errors(null)
                .build();
    }
}
