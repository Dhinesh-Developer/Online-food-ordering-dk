package com.dk.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class IngredientsItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToOne
    private IngredientCategory category;

    @JsonIgnore
    @ManyToOne
    private Restaurant restaurant;


    private boolean inStock = true;


    public IngredientsItem() {
    }

    public IngredientsItem(int id, String name, IngredientCategory category, Restaurant restaurant, boolean inStock) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.restaurant = restaurant;
        this.inStock = inStock;
    }

    public IngredientsItem(String name, IngredientCategory category, Restaurant restaurant, boolean inStock) {
        this.name = name;
        this.category = category;
        this.restaurant = restaurant;
        this.inStock = inStock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public IngredientCategory getCategory() {
        return category;
    }

    public void setCategory(IngredientCategory category) {
        this.category = category;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    @Override
    public String toString() {
        return "IngredientsItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", restaurant=" + restaurant +
                ", inStock=" + inStock +
                '}';
    }
}
