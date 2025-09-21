package com.dk.service;

import com.dk.model.Order;
import com.dk.model.User;
import com.dk.request.OrderRequest;

public interface OrderService {

    public Order createOrder(OrderRequest res, User user);


}
