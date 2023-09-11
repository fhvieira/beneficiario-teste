package com.example.beneficiariotest.exception;

public class BeneficiarioAlreadyExistsException extends EntityAlreadyExistsException {
    public BeneficiarioAlreadyExistsException(String msg) {
        super(msg);
    }
}
