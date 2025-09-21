package com.dk.service;

import com.dk.model.Category;
import com.dk.model.Food;
import com.dk.model.Restaurant;
import com.dk.request.CreateFoodRequest;
import com.dk.request.CreateRestaurantRequest;

import java.util.List;

public interface FoodService {

    public Food createFood(CreateFoodRequest req, Category category, Restaurant restaurant);
    public void deleteFood(Long foodId) throws Exception;
    public List<Food> getRestaurantFood(Long restaurantId,
                                        boolean isVegiterain,
                                        boolean isNonVeg,
                                        boolean isSeasonal,
                                        String foodCategory);

    public List<Food> searchFood(String keyword);
    public Food findFoodById(Long foodId) throws Exception;
    public Food updateAvailablityStatus(Long foodId) throws Exception;

}
