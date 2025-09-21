package com.dk.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
public class IngredientCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @JsonIgnore
    @ManyToOne
    private Restaurant restaurant;

    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
    private List<IngredientsItem> ingredientsItemList = new ArrayList<>();

    public IngredientCategory() {
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

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<IngredientsItem> getIngredientsItemList() {
        return ingredientsItemList;
    }

    public void setIngredientsItemList(List<IngredientsItem> ingredientsItemList) {
        this.ingredientsItemList = ingredientsItemList;
    }

    public IngredientCategory(int id, String name, Restaurant restaurant, List<IngredientsItem> ingredientsItemList) {
        this.id = id;
        this.name = name;
        this.restaurant = restaurant;
        this.ingredientsItemList = ingredientsItemList;
    }

    public IngredientCategory(String name, Restaurant restaurant, List<IngredientsItem> ingredientsItemList) {
        this.name = name;
        this.restaurant = restaurant;
        this.ingredientsItemList = ingredientsItemList;
    }

    @Override
    public String toString() {
        return "IngredientCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", restaurant=" + restaurant +
                ", ingredientsItemList=" + ingredientsItemList +
                '}';
    }
}
