package com.dk.service;
import com.dk.dto.RestaurantDto;
import com.dk.model.User;
import com.dk.model.Restaurant;
import com.dk.request.CreateRestaurantRequest;

import java.util.List;

public interface RestaurantService {

    public Restaurant createRestaurant(CreateRestaurantRequest req, User user);
    public Restaurant updateRestaurant(Long restaurantId,CreateRestaurantRequest updateRestaurant) throws Exception;
    public void deleteRestaurant(Long restaurantId) throws Exception;

    public List<Restaurant> getAllRestaurant();
    public List<Restaurant> searchRestaurant(String keyword);

    public Restaurant findRestaurantById(Long id) throws Exception;
    public Restaurant getRestaurantByUserId(Long userId) throws Exception;

    public RestaurantDto addToFavourite(Long restaurantId,User user) throws Exception;
    public Restaurant updateRestaurantStatus(Long id) throws Exception;
}
