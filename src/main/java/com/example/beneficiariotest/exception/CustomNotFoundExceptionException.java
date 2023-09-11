package com.example.beneficiariotest.exception;

public class CustomNotFoundExceptionException extends RuntimeException {
    public CustomNotFoundExceptionException(String msg) {
        super(msg);
    }
}
