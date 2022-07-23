package com.kepco.etax.api.exception;

public class EntityExistException extends RuntimeException {
    public EntityExistException() {
        super();
    }

    public EntityExistException(String message) {
        super(message);
    }

    public EntityExistException(String message, Throwable cause) {
        super(message, cause);
    }
}
