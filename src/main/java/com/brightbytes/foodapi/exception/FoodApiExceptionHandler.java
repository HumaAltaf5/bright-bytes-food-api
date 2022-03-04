package com.brightbytes.foodapi.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

    @ControllerAdvice

    public class FoodApiExceptionHandler {
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;

        @ExceptionHandler(value = { FoodApiRequestException.class })
        public ResponseEntity<Object> handleApiRequestException(FoodApiRequestException e) {
            FoodApiException apiException = new FoodApiException(e.getMessage(), badRequest, ZonedDateTime.now(ZoneId.of("Z")));
            return new ResponseEntity<>(apiException, badRequest);
        }
    }

