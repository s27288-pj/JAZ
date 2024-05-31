package com.jaz2.figurines.Exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@ControllerAdvice
public class FigurineExceptionHandler {

        Logger logger = LogManager.getLogger(FigurineExceptionHandler.class);

        @ExceptionHandler(FigurineNotFoundException.class)
        @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Figurine not found")
        public void handleFigurineNotFound(HttpServletRequest request, Exception ex) {
            logger.warn("Figurine not found: " + request.getRequestURL() + " raised " + ex.getMessage());
        }

        @ExceptionHandler(BadFigurineFieldsException.class)
        @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Figurine fields are invalid")
        public void handleBadFigurineFields(HttpServletRequest request, Exception ex) {
            logger.warn("Invalid figurine fields: " + request.getRequestURL() + " raised " + ex.getMessage());
        }
}
