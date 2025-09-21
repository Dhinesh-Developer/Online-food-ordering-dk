package com.dk.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity

public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //many order item have same food
    @ManyToOne
    private Food food;

    private int quantity;

    private Long totalPrice;

    private List<String> ingredients;

    public OrderItem() {
    }

    public OrderItem(Food food, int quantity, Long totalPrice, List<String> ingredients) {
        this.food = food;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.ingredients = ingredients;
    }

    public OrderItem(Long id, Food food, int quantity, Long totalPrice, List<String> ingredients) {
        this.id = id;
        this.food = food;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.ingredients = ingredients;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", food=" + food +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                ", ingredients=" + ingredients +
                '}';
    }
}
