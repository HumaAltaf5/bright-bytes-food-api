package com.brightbytes.foodapi.repository;

import com.brightbytes.foodapi.model.Dish;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HealthyFoodRepository extends CrudRepository<Dish, Long> {
}

