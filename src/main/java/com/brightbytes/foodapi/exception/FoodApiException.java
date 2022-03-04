package com.brightbytes.foodapi.exception;


import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

public class FoodApiException {
    private final String message;
    private final HttpStatus status;
    private final ZonedDateTime timestDateTime;

    public FoodApiException(String message, HttpStatus status, ZonedDateTime timestDateTime) {
        this.message = message;
        this.status = status;
        this.timestDateTime = timestDateTime;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public ZonedDateTime getTimestDateTime() {
        return timestDateTime;
    }
}

