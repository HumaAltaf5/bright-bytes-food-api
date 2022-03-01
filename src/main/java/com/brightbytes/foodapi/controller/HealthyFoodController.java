package com.brightbytes.foodapi.controller;

import com.brightbytes.foodapi.model.Dish;
import com.brightbytes.foodapi.service.HealthyFoodServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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


    @GetMapping(value = "/meals/calories")
    public ResponseEntity<List<Dish>> getDishByCaloriesAndType(@RequestParam(name = "type", required = false, defaultValue="") String type, @RequestParam(name = "cal", required = true, defaultValue="0") int calories) throws Exception {
        List<Dish> dish = new ArrayList<>();
        try {
            if (type.equals("") && calories == 0) {
                dish = healthyFoodService.getAllDishes();
            } else if(type.equals("") && calories != 0) {
                dish = healthyFoodService.getDishByCalories(calories);
            } else if(!type.equals("") && calories == 0) {
                dish = healthyFoodService.getDishByType(type);
            } else if(!type.equals("") && calories != 0) {
                dish = healthyFoodService.getDishByCaloriesAndType(type, calories);
            }
            return new ResponseEntity<>(dish, HttpStatus.OK);

        } catch(Exception e)  {
            System.out.println(e);
        }
        return null;
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public String handleMissingParams(MissingServletRequestParameterException ex) {
        String messg = "";
        System.out.println("Encountered" + ex + "Exception");
        messg = "The request is invalid as it is missing parameters. Please input the correct parameters eg:";
        messg = messg + "/meals/calories?cal=val(val= total calories for 3 meals eg. 2000)";
        return messg;
    }
}
