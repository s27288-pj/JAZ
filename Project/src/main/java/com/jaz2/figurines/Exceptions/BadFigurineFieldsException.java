package com.jaz2.figurines.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Figurine fields are invalid")
public class BadFigurineFieldsException extends RuntimeException {
    public BadFigurineFieldsException(String message) {
        super(message);
    }
}
