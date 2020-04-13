package com.example.currency_exchange.exceptions;

public class DataException extends RuntimeException{
    public DataException(String message) {
        super(message);
    }

    public DataException(String message, Throwable cause) {
        super(message, cause);
    }
}
