package com.dk.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


public class RestaurantDto {
    private Long id;
    private String title;
    private String description;
    private List<String> images;

    public RestaurantDto() {
    }

    @Override
    public String toString() {
        return "RestaurantDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", images=" + images +
                '}';
    }

    public RestaurantDto(Long id, String title, String description, List<String> images) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.images = images;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
