package com.cursor.mopla.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler({NullEntityReferenceException.class, IllegalArgumentException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> nullEntityReferenceExceptionHandler(HttpServletRequest request, NullEntityReferenceException exception) {
        return getResponse(request, HttpStatus.BAD_REQUEST, exception);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ResponseEntity<?> entityNotFoundExceptionHandler(HttpServletRequest request, EntityNotFoundException exception) {
        return getResponse(request, HttpStatus.NOT_FOUND, exception);
    }

    @ExceptionHandler({AccessDeniedException.class, WrongCredentialException.class})
    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    public ResponseEntity<?> accessDeniedHandler(HttpServletRequest request, AccessDeniedException exception) {
        return getResponse(request, HttpStatus.FORBIDDEN, exception);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<?> internalServerErrorHandler(HttpServletRequest request, Exception exception) {
        return getResponse(request, HttpStatus.INTERNAL_SERVER_ERROR, exception);
    }

    private ResponseEntity<?> getResponse(HttpServletRequest request, HttpStatus httpStatus, Exception exception) {
        logger.error("Exception raised = {} :: URL = {}", exception.getMessage(), request.getRequestURL());
        Map<String, Object> response = new HashMap<>();
        response.put("code", httpStatus.value() + " / " + httpStatus.getReasonPhrase());
        response.put("message", exception.getMessage());
        return new ResponseEntity<>(response, httpStatus);
    }
}