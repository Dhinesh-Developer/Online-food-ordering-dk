package com.dk.service;

import com.dk.model.Order;
import com.dk.model.User;
import com.dk.request.OrderRequest;

import java.util.List;

public interface OrderService {

    public Order createOrder(OrderRequest order, User user) throws Exception;
    public Order updateOrder(Long orderId,String orderStatue)throws Exception;
    public void cancelOrder(Long orderId) throws Exception;
    public List<Order> getUsersOrders(Long userId)throws Exception;
    public List<Order> getRestaurantOrder(Long restaurantId,String orderStatus)throws Exception;
    public Order findOrderById(Long orderId) throws Exception;
}
