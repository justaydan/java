package com.lessons.exception;

public class AccountBlockedException extends PaymentException {
    public AccountBlockedException(String message) {
        super(message);
    }
}
