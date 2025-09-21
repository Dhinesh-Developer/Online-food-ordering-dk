package com.dk.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JsonIgnore
    private Cart cart;

    @ManyToOne
    private Food food;

    private int quantity;

    private List<String> ingredients;

    private Long totalPrice;

    public CartItem(int id, Cart cart, Food food, int quantity, List<String> ingredients, Long totalPrice) {
        this.id = id;
        this.cart = cart;
        this.food = food;
        this.quantity = quantity;
        this.ingredients = ingredients;
        this.totalPrice = totalPrice;
    }

    public CartItem(Cart cart, Food food, int quantity, List<String> ingredients, Long totalPrice) {
        this.cart = cart;
        this.food = food;
        this.quantity = quantity;
        this.ingredients = ingredients;
        this.totalPrice = totalPrice;
    }

    public CartItem() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", cart=" + cart +
                ", food=" + food +
                ", quantity=" + quantity +
                ", ingredients=" + ingredients +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
