package com.brightbytes.foodapi.repository;

import com.brightbytes.foodapi.model.Dish;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public class HealthyFoodRepository {
    @Repository
    public interface BookManagerRepository extends CrudRepository<Dish, Long> {

    }
}
