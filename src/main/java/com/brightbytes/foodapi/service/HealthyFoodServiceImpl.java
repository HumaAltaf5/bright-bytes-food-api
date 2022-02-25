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
        public List<Dish> getAll() {
            List<Dish> dish = new ArrayList<>();
            healthyFoodRepository.findAll();
            return dish;
        }

}
