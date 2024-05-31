package com.jaz2.figurines.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Owner fields are invalid")
public class BadOwnerFieldsException extends RuntimeException {
    public BadOwnerFieldsException(String message) {
        super(message);
    }
}
