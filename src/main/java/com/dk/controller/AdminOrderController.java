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
public class AdminOrderController {

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;


    @GetMapping("/order/restaurant/{id}")
    public ResponseEntity<List<Order>> getOrderHistory(
            @PathVariable Long id,
            @RequestParam(required = false) String order_status,
            @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserByJwtToken(jwt);
        List<Order> order = orderService.getRestaurantOrder(id,order_status);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PutMapping("/order/{orderId}/{orderStatus}")
    public ResponseEntity<Order> updateOrderStatus(
            @PathVariable Long orderId,
            @PathVariable String orderStatus,

            @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserByJwtToken(jwt);
        Order order = orderService.updateOrder(orderId,orderStatus);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }


}
