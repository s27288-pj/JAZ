package com.jaz2.figurines.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Figurine not found")
public class FigurineNotFoundException extends RuntimeException {
    public FigurineNotFoundException(String message) {
        super(message);
    }
}
