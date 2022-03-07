package com.brightbytes.foodapi.service;

import com.brightbytes.foodapi.model.Dish;
import com.brightbytes.foodapi.repository.HealthyFoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HealthyFoodServiceImpl implements HealthyFoodService {

    @Autowired
    HealthyFoodRepository healthyFoodRepository;

    @Override
    public List<Dish> getAllDishes() {
        List<Dish> dish = new ArrayList<>();
        healthyFoodRepository.findAll().forEach(dish::add);
        return dish;
    }

    @Override
    public List<Dish> getDishByCalories(int calories) {
        List<Dish> dish = new ArrayList<>();
        healthyFoodRepository.getDishByCalories(calories).forEach(dish::add);
        return dish;
    }

    public List<Dish> getDishByType(String mealType) {
        List<Dish> dish = new ArrayList<>();
        healthyFoodRepository.getDishByType(mealType).forEach(dish::add);
        return dish;
    }

    public List<Dish> getDishByCaloriesAndType(String mealType, int calories) {
        List<Dish> dish = new ArrayList<>();
        healthyFoodRepository.getDishByCaloriesAndType(mealType, calories).forEach(dish::add);
        return dish;
    }

    public List<Dish> getDishByAllergyType(String allergyType) {
        List<Dish> dish = new ArrayList<>();
        healthyFoodRepository.getDishByAllergyInfo(allergyType).forEach(dish::add);
        return dish;
    }
}

