package com.kepco.etax.api.exception;

public class ExpiredAccessTokenException extends RuntimeException {
    public ExpiredAccessTokenException() {
        super();
    }

    public ExpiredAccessTokenException(String message) {
        super(message);
    }

    public ExpiredAccessTokenException(String message, Throwable cause) {
        super(message, cause);
    }
}

