package com.brightbytes.foodapi.service;

import com.brightbytes.foodapi.model.Dish;

import java.util.ArrayList;
import java.util.List;

public interface HealthyFoodService {
    List<Dish> getAllDishes();
    List<Dish> getDishByCalories(int calories);
    List<Dish> getDishByType(String mealType);
}
