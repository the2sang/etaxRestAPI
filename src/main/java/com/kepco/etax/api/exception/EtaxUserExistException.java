package com.kepco.etax.api.exception;

public class EtaxUserExistException extends RuntimeException {
    public EtaxUserExistException() {
        super();
    }

    public EtaxUserExistException(String message) {
        super(message);
    }

    public EtaxUserExistException(String message, Throwable cause) {
        super(message, cause);
    }
}
