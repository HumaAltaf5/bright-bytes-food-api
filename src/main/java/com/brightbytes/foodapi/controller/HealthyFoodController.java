package com.brightbytes.foodapi.controller;

import com.brightbytes.foodapi.model.Dish;
import com.brightbytes.foodapi.service.HealthyFoodServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class HealthyFoodController {

    @Autowired
    HealthyFoodServiceImpl healthyFoodService;

    @GetMapping
    public String home() {
        return "Welcome to the Healthy Food API";
    }

    @GetMapping(value = "/meals")
    public ResponseEntity<List<Dish>> getAllMeals() {
        List<Dish> dish = healthyFoodService.getAllDishes();
        return new ResponseEntity<>(dish, HttpStatus.OK);
    }

    @GetMapping(value = "/info")
    public String info() {
        return "This is a Healthy Food API";
    }
}
