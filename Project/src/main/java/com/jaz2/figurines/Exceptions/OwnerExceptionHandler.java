package com.jaz2.figurines.Exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@ControllerAdvice
public class OwnerExceptionHandler {
    
    Logger logger = LogManager.getLogger(OwnerExceptionHandler.class);
    
    @ExceptionHandler(OwnerNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Owner not found")
    public void handleOwnerNotFound(HttpServletRequest request, Exception ex) {
        logger.warn("Owner not found: " + request.getRequestURL() + " raised " + ex.getMessage());
    }

    @ExceptionHandler(BadOwnerFieldsException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Owner fields are invalid")
    public void handleBadOwnerFields(HttpServletRequest request, Exception ex) {
        logger.warn("Invalid owner fields: " + request.getRequestURL() + " raised " + ex.getMessage());
    }
}
