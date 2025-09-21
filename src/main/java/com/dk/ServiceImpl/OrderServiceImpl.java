package com.dk.ServiceImpl;

import com.dk.Repository.*;
import com.dk.model.*;
import com.dk.request.OrderRequest;
import com.dk.service.CartService;
import com.dk.service.OrderService;
import com.dk.service.RestaurantService;
import com.dk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PrivateKey;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRespository addressRespository;

    @Autowired
    private RestaurantRespository restaurantRespository;

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private CartService cartService;

    @Override
    public Order createOrder(OrderRequest order, User user) throws Exception {
        Address shippingAddress = order.getDeliveryAddress();
        Address savedAddress = addressRespository.save(shippingAddress);
        if(!user.getAddresses().contains(savedAddress)){
            user.getAddresses().add(savedAddress);
            userRepository.save(user);
        }

        Restaurant restaurant = restaurantService.findRestaurantById(order.getRestaurantId());

        Order createOrder = new Order();
        createOrder.setCustomer(user);
        createOrder.setCreatedAt(new Date());
        createOrder.setOrderStatus("PENDING");
        createOrder.setDeliveryAddress(savedAddress);
        createOrder.setRestaurant(restaurant);

        Cart cart =cartService.findCartByUserId(user.getId());
        List<OrderItem> orderItems = new ArrayList<>();

        for(CartItem cartItem : cart.getItem()){
            OrderItem orderItem = new OrderItem();
            orderItem.setFood(cartItem.getFood());
            orderItem.setIngredients(cartItem.getIngredients());
            orderItem.setQuantity(cartItem.getQuantity());
            orderItem.setTotalPrice(cartItem.getTotalPrice());
            OrderItem savedOrderItem = orderItemRepository.save(orderItem);
            orderItems.add(savedOrderItem);
        }

         Long totalPrice = cartService.calculateCartTotals(cart);

        createOrder.setItems(orderItems);
        createOrder.setTotalPrice(totalPrice);

        Order savedOrder  = orderRepository.save(createOrder);
        restaurant.getOrders().add(savedOrder);

        return createOrder;
    }

    @Override
    public Order updateOrder(Long orderId, String orderStatue) throws Exception {
        Order order = findOrderById(orderId);
        if(orderStatue.equals("OUT_FOR_DELIVERED") || orderStatue.equals("DELIVERED")
                || orderStatue.equals("COMPLETED") || orderStatue.equals("PENDING")){
            order.setOrderStatus(orderStatue);
            return orderRepository.save(order);
        }
        throw new Exception("Please select a valid order status");
    }

    @Override
    public void cancelOrder(Long orderId) throws Exception {
        Order order = findOrderById(orderId);

        orderRepository.deleteById(orderId);
    }

    @Override
    public List<Order> getUsersOrders(Long userId) throws Exception {
        return orderRepository.findByCustomerId(userId);
    }

    @Override
    public List<Order> getRestaurantOrder(Long restaurantId, String orderStatus) throws Exception {
        List<Order> orders =  orderRepository.findByRestaurantId(restaurantId);
        if(orderStatus != null){
            orders = orders.stream().filter(order ->
                    order.getOrderStatus().equals(orderStatus)).collect(Collectors.toList());
        }
        return orders;
    }

    @Override
    public Order findOrderById(Long orderId) throws Exception {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        if(optionalOrder.isEmpty()){
            throw new Exception("Order not found");
        }
        return optionalOrder.get();
    }
}
