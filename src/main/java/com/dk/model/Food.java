package com.dk.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;

    private String description;
    private Long price;

    // many food have same category.
    @ManyToOne
    private Category foodCategory;

    @Column(length = 1000)
    @ElementCollection
    private List<String> images;


    private boolean available;

    @ManyToOne
    private Restaurant restaurant;

    private boolean isVegetarian;

    private boolean isSeasonal;

    @ManyToMany
    private List<IngredientsItem> ingredientsItems = new ArrayList<>();

    public Food() {
    }

    public Food(String name, String description, Long price, Category foorCategory, List<String> images, boolean available, Restaurant restaurant, boolean isVegetarian, boolean isSeasonal, List<IngredientsItem> ingredientsItems, Date creationDate) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.foodCategory = foorCategory;
        this.images = images;
        this.available = available;
        this.restaurant = restaurant;
        this.isVegetarian = isVegetarian;
        this.isSeasonal = isSeasonal;
        this.ingredientsItems = ingredientsItems;
        this.creationDate = creationDate;
    }

    public Food(Long id, String name, String description, Long price, Category foorCategory, List<String> images, boolean available, Restaurant restaurant, boolean isVegetarian, boolean isSeasonal, List<IngredientsItem> ingredientsItems, Date creationDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.foodCategory = foorCategory;
        this.images = images;
        this.available = available;
        this.restaurant = restaurant;
        this.isVegetarian = isVegetarian;
        this.isSeasonal = isSeasonal;
        this.ingredientsItems = ingredientsItems;
        this.creationDate = creationDate;
    }

    private Date creationDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Category getFoorCategory() {
        return foodCategory;
    }

    public void setFoorCategory(Category foorCategory) {
        this.foodCategory = foorCategory;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public boolean isVegetarian() {
        return isVegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        isVegetarian = vegetarian;
    }

    public boolean isSeasonal() {
        return isSeasonal;
    }

    public void setSeasonal(boolean seasonal) {
        isSeasonal = seasonal;
    }

    public List<IngredientsItem> getIngredientsItems() {
        return ingredientsItems;
    }

    public void setIngredientsItems(List<IngredientsItem> ingredientsItems) {
        this.ingredientsItems = ingredientsItems;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", foorCategory=" + foodCategory +
                ", images=" + images +
                ", available=" + available +
                ", restaurant=" + restaurant +
                ", isVegetarian=" + isVegetarian +
                ", isSeasonal=" + isSeasonal +
                ", ingredientsItems=" + ingredientsItems +
                ", creationDate=" + creationDate +
                '}';
    }
}
