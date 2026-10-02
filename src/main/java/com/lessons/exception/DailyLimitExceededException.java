package com.lessons.exception;

public class DailyLimitExceededException extends PaymentException {
    public DailyLimitExceededException(String message) {
        super(message);
    }
}
