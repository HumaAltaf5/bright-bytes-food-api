package com.brightbytes.foodapi.repository;

import com.brightbytes.foodapi.model.Dish;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HealthyFoodRepository extends CrudRepository<Dish, Long> {
    @Query(nativeQuery = true,value = "SELECT * from dish WHERE mealtype = :mealType LIMIT 3")
    List<Dish> getDishByType(String mealType);
}

