package com.dk.controller;

import com.dk.model.Food;
import com.dk.model.Restaurant;
import com.dk.model.User;
import com.dk.request.CreateFoodRequest;
import com.dk.response.MessageResponse;
import com.dk.service.FoodService;
import com.dk.service.RestaurantService;
import com.dk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/food")
public class AdminFoodController {

    @Autowired
    private FoodService foodService;

    @Autowired
    private UserService userService;

    @Autowired
    private RestaurantService restaurantService;


    @PostMapping()
    public ResponseEntity<Food> createFood(@RequestBody CreateFoodRequest req,
                                           @RequestHeader("Authorization") String jwt) throws Exception {

        User user =  userService.findUserByJwtToken(jwt);
        Restaurant restaurant = restaurantService.findRestaurantById(req.getRestaurantId());
        Food food = foodService.createFood(req,req.getCategory(),restaurant);

        return new ResponseEntity<>(food, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> deleteFood(@PathVariable Long id,
                                           @RequestHeader("Authorization") String jwt
                                           ) throws Exception {

        User user =  userService.findUserByJwtToken(jwt);
        foodService.deleteFood(id);
        MessageResponse res =  new MessageResponse();
        res.setMessage("food deleted successfully");

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Food> updateFoodAvailablityStatus(@PathVariable Long id,
                                                      @RequestHeader("Authorization") String jwt
    ) throws Exception {

        User user =  userService.findUserByJwtToken(jwt);
        Food food = foodService.updateAvailablityStatus(id);

        return new ResponseEntity<>(food, HttpStatus.CREATED);
    }




}
