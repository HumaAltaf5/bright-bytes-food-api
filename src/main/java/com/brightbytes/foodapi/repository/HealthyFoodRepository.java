package com.brightbytes.foodapi.repository;

import com.brightbytes.foodapi.model.Dish;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HealthyFoodRepository extends CrudRepository<Dish, Long> {

    @Query(nativeQuery = true,value = "(select b_id as id, b_name as name, b_category as category, b_mealtype as mealtype, b_calories as calories, b_recipelink as recipelink, b_imagelink as imagelink, b_allergens as allergens from "+
            "plan_view where total_calories <= :calories ORDER BY total_calories desc LIMIT 1) "+
            "UNION "+
            "(select l_id as id, l_name as name, l_category as category, l_mealtype as mealtype, l_calories as calories, l_recipelink as recipelink, l_imagelink as imagelink, l_allergens as allergens from "+
            "plan_view where total_calories <= :calories ORDER BY total_calories desc LIMIT 1) "+
            "UNION "+
            "(select d_id as id, d_name as name, d_category as category, d_mealtype as mealtype, d_calories as calories, d_recipelink as recipelink, d_imagelink as imagelink, d_allergens as allergens from "+
            "plan_view where total_calories <= :calories ORDER BY total_calories desc LIMIT 1)")
    List<Dish> getDishByCalories(int calories);

    @Query(nativeQuery = true,value = "(SELECT * from dish WHERE mealtype = :mealType AND category = 'Breakfast' ORDER BY RAND() LIMIT 1)\n" +
            "UNION\n" +
            "(SELECT * from dish WHERE mealtype = :mealType AND category = 'Lunch' ORDER BY RAND() LIMIT 1)\n" +
            "UNION\n" +
            "(SELECT * from dish WHERE mealtype = :mealType AND category = 'Dinner' ORDER BY RAND() LIMIT 1);" )
    List<Dish> getDishByType(String mealType);

    @Query(nativeQuery = true,value = "(select b_id as id, b_name as name, b_category as category, b_mealtype as mealtype, b_calories as calories, b_recipelink as recipelink, b_imagelink as imagelink, b_allergens as allergens from "+
            "plan_view where total_calories <= :calories AND b_mealType = :mealType AND l_mealType = :mealType AND d_mealType = :mealType ORDER BY total_calories desc LIMIT 1) "+
            "UNION "+
            "(select l_id as id, l_name as name, l_category as category, l_mealtype as mealtype, l_calories as calories, l_recipelink as recipelink, l_imagelink as imagelink, l_allergens as allergens from "+
            "plan_view where total_calories <= :calories AND b_mealType = :mealType AND l_mealType = :mealType AND d_mealType = :mealType ORDER BY total_calories desc LIMIT 1) "+
            "UNION "+
            "(select d_id as id, d_name as name, d_category as category, d_mealtype as mealtype, d_calories as calories, d_recipelink as recipelink, d_imagelink as imagelink, d_allergens as allergens from "+
            "plan_view where total_calories <= :calories AND b_mealType = :mealType AND l_mealType = :mealType AND d_mealType = :mealType ORDER BY total_calories desc LIMIT 1)")
    //@Query(nativeQuery = true,value = "select * from (select *,sum(calories) OVER (ORDER BY calories DESC)x from dish) a where x <= :calories AND mealtype = :mealType")
    List<Dish> getDishByCaloriesAndType(String mealType, int calories);

    @Query(nativeQuery = true,value = "(SELECT * from dish WHERE category = 'Breakfast' AND allergens <> :allergyType ORDER BY RAND() LIMIT 1)\n" +
            "UNION\n" +
            "(SELECT * from dish WHERE category = 'Lunch' AND allergens <> :allergyType ORDER BY RAND() LIMIT 1)\n" +
            "UNION\n" +
            "(SELECT * from dish WHERE category = 'Dinner' AND allergens <> :allergyType ORDER BY RAND() LIMIT 1);" )
    List<Dish> getDishByAllergyInfo(String allergyType);
}

