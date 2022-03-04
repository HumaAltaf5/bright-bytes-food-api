package com.brightbytes.foodapi.exception;

public class FoodApiRequestException extends RuntimeException {
        public FoodApiRequestException(String message) {
            super(message);
        }

        public FoodApiRequestException(String message, Throwable cause) {
            super(message,cause);
        }
    }

