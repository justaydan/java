package com.lessons.exception;

public class StockUpdateException extends RuntimeException {

    public StockUpdateException(String message) {
        super(message);
    }
}
