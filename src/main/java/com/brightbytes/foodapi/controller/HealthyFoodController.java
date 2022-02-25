package com.brightbytes.foodapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthyFoodController {

    @GetMapping(value = "/")
    public String home() {
        return "Welcome to the Healthy Food API";
    }
}
