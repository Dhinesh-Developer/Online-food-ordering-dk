package com.dk.service;

import com.dk.model.Cart;
import com.dk.model.CartItem;
import com.dk.request.AddCartItemRequest;

public interface CartService {

    public CartItem addItemToCart(AddCartItemRequest req, String jwt) throws Exception;
    public CartItem updateCartItemQuantity(Long cartItemId,int quantity) throws Exception;
    public Cart removeItemFromCart(Long cartItemId,String jwt) throws Exception;
    public Long calculateCartTotals(Cart cart) throws Exception;
    public Cart findCartById(Long id) throws Exception;
    public Cart findCartByUserId(Long userId) throws Exception;
    public Cart clearCart(Long userId)throws Exception;

}
