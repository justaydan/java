package com.lessons.exception;

public class OrderStatusTransitionException extends RuntimeException {
    public OrderStatusTransitionException(String message) {
        super(message);
    }
}
