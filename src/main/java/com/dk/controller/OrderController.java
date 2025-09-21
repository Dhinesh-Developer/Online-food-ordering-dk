package com.dk.controller;

import com.dk.model.CartItem;
import com.dk.model.Order;
import com.dk.model.User;
import com.dk.request.AddCartItemRequest;
import com.dk.request.OrderRequest;
import com.dk.service.OrderService;
import com.dk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @PostMapping("/order")
    public ResponseEntity<Order> createOrder(@RequestBody OrderRequest req,
                                                  @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserByJwtToken(jwt);
        Order order = orderService.createOrder(req,user);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @GetMapping("/order/user")
    public ResponseEntity<List<Order>> getOrderHistory(
                                                       @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserByJwtToken(jwt);
        List<Order> order = orderService.getUsersOrders(user.getId());
        return new ResponseEntity<>(order, HttpStatus.OK);
    }




}
