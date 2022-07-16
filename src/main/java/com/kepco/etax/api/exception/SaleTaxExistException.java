package com.kepco.etax.api.exception;

public class SaleTaxExistException extends RuntimeException {
    public SaleTaxExistException() {
        super();
    }

    public SaleTaxExistException(String message) {
        super(message);
    }

    public SaleTaxExistException(String message, Throwable cause) {
        super(message, cause);
    }
}
