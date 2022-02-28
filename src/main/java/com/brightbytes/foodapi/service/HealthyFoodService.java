package com.brightbytes.foodapi.service;

import com.brightbytes.foodapi.model.Dish;

import java.util.List;

public interface HealthyFoodService {
    List<Dish> getAllDishes();
    List<Dish> getDishByType(String mealType);
}
