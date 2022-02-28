package com.brightbytes.foodapi.controller;

import com.brightbytes.foodapi.model.Dish;
import com.brightbytes.foodapi.service.HealthyFoodServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@AutoConfigureMockMvc
@SpringBootTest
public class HealthyFoodControllerTests {

    @Mock
    private HealthyFoodServiceImpl mockHealthyFoodServiceImpl;

    @InjectMocks
    private HealthyFoodController healthyFoodController;

    @Autowired
    private MockMvc mockMvcController;

    @BeforeEach
    public void setup(){
        mockMvcController = MockMvcBuilders.standaloneSetup(healthyFoodController).build();
    }

    @Test
    public void testGetHome() throws Exception {
        String expectedContent = "Welcome to the Healthy Food API";
        this.mockMvcController.perform(
                     MockMvcRequestBuilders.get("/"))
            .andExpect(MockMvcResultMatchers.status().isOk())
          .andExpect(MockMvcResultMatchers.content().string(expectedContent));
    }

    @Test
    public void testGetMeals() throws Exception {
        List<Dish> dish = new ArrayList<>();
        dish.add(new Dish(1L, "Dish one", "breakfast", "nonveg", 500, "recipe1", "image1"));
        dish.add(new Dish(2L, "Dish two", "lunch", "nonveg", 800, "recipe2", "image2"));
        dish.add(new Dish(3L, "Dish three", "dinner", "veg", 800, "recipe3", "image3"));

        when(mockHealthyFoodServiceImpl.getAllDishes()).thenReturn(dish);
        mockMvcController = MockMvcBuilders.standaloneSetup(healthyFoodController).build();
        this.mockMvcController.perform(
                        MockMvcRequestBuilders.get("/meals"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Dish one"));
    }

    @Test
    public void testGetMealsByType() throws Exception {
        List<Dish> dish = new ArrayList<>();
        dish.add(new Dish(1L, "Dish one", "breakfast", "nonveg", 500, "recipe1", "image1"));
        dish.add(new Dish(2L, "Dish two", "lunch", "nonveg", 800, "recipe2", "image2"));
        dish.add(new Dish(3L, "Dish three", "dinner", "veg", 800, "recipe3", "image3"));

        when(mockHealthyFoodServiceImpl.getDishByType("nonveg")).thenReturn(dish);
        mockMvcController = MockMvcBuilders.standaloneSetup(healthyFoodController).build();
        this.mockMvcController.perform(
                        MockMvcRequestBuilders.get("/meals/calories?type=nonveg&cal=800"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].mealtype").value("nonveg"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].mealtype").value("nonveg"));
    }
}
