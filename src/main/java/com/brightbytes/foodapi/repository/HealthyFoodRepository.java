package com.brightbytes.foodapi.repository;

import com.brightbytes.foodapi.model.Dish;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HealthyFoodRepository extends CrudRepository<Dish, Long> {

    @Query(nativeQuery = true,value = "select * from (select *,sum(calories) OVER (ORDER BY calories DESC)x from dish) a where x <= :calories")
    List<Dish> getDishByCalories(int calories);

    @Query(nativeQuery = true,value = "SELECT * from dish WHERE mealtype = :mealType LIMIT 3")
    List<Dish> getDishByType(String mealType);

    @Query(nativeQuery = true,value = "SELECT * from dish WHERE mealtype = :mealType AND calories = :calories LIMIT 3")
    //@Query(nativeQuery = true,value = "select * from (select *,sum(calories) OVER (ORDER BY calories DESC)x from dish) a where x <= :calories AND mealtype = :mealType")
    List<Dish> getDishByCaloriesAndType(String mealType, int calories);
}

