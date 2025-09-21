package com.dk.ServiceImpl;

import com.dk.Repository.CartItemRepository;
import com.dk.Repository.CartRepository;
import com.dk.Repository.FoodRepository;
import com.dk.model.Cart;
import com.dk.model.CartItem;
import com.dk.model.Food;
import com.dk.model.User;
import com.dk.request.AddCartItemRequest;
import com.dk.service.CartService;
import com.dk.service.FoodService;
import com.dk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private FoodService foodService;

    @Override
    public CartItem addItemToCart(AddCartItemRequest req, String jwt) throws Exception {
        User user = userService.findUserByJwtToken(jwt);
        Food food = foodService.findFoodById(req.getFoodId());
        Cart cart = cartRepository.findByCustomer(user.getId());
        for(CartItem x : cart.getItem()){
            if(x.getFood().equals(food)){
                int newQuantity = x.getQuantity()+req.getQuantity();
                return updateCartItemQuantity((long)x.getId(),newQuantity);
            }
        }
        CartItem newCartItem = new CartItem();
        newCartItem.setFood(food);
        newCartItem.setCart(cart);
        newCartItem.setQuantity(req.getQuantity());
        newCartItem.setIngredients(req.getIngredients());
        newCartItem.setTotalPrice(req.getQuantity()*food.getPrice());

        CartItem savedCartItem = cartItemRepository.save(newCartItem);
        cart.getItem().add(savedCartItem);
        return savedCartItem;
    }

    @Override
    public CartItem updateCartItemQuantity(Long cartItemId, int quantity) throws Exception {
        Optional<CartItem> cartItemOptional = cartItemRepository.findById(cartItemId);
        if(cartItemOptional.isEmpty()){
            throw new Exception("Cart item not found");
        }

        CartItem cartItem = cartItemOptional.get();
        cartItem.setQuantity(quantity);
        cartItem.setTotalPrice((cartItem.getFood().getPrice())*quantity);

        return cartItemRepository.save(cartItem);
    }

    @Override
    public Cart removeItemFromCart(Long cartItemId, String jwt) throws Exception {
        User user = userService.findUserByJwtToken(jwt);
        Cart cart = cartRepository.findByCustomer(user.getId());
        Optional<CartItem> cartItemOptional = cartItemRepository.findById(cartItemId);
        if(cartItemOptional.isEmpty()){
            throw new Exception("Cart item not found");
        }

        CartItem item = cartItemOptional.get();
        cart.getItem().remove(item);
        return cartRepository.save(cart);
    }

    @Override
    public Long calculateCartTotals(Cart cart) throws Exception {
        Long total = 0L;
        for(CartItem x : cart.getItem()){
            total += x.getFood().getPrice() * x.getQuantity();

        }

        return total;
    }

    @Override
    public Cart findCartById(Long id) throws Exception {
        Optional<Cart> optionalCart = cartRepository.findById(id);
        if(optionalCart.isEmpty()){
            throw new Exception("cart not found with id: "+id);
        }

        return optionalCart.get();
    }

    @Override
    public Cart findCartByUserId(Long userId) throws Exception {
     //   User user = userService.findUserByJwtToken(jwt);

        Cart cart =  cartRepository.findByCustomer(userId);
        cart.setTotal(calculateCartTotals(cart));
        return cart;
    }

    @Override
    public Cart clearCart(Long userId) throws Exception {
       // User user = userService.findUserByJwtToken(jwt);
        Cart cart = findCartByUserId(userId);
        cart.getItem().clear();

        return cartRepository.save(cart);
    }
}
