package com.kepco.etax.api.exception;



public class EtaxUserNotFoundException extends RuntimeException {

    public EtaxUserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public EtaxUserNotFoundException(String message) {
        super(message);
    }

    public EtaxUserNotFoundException() {
        super();
    }
}

