package com.dk.Repository;

import com.dk.model.Food;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {


    List<Food> findByRestaurant_Id(Long restaurantId);


    @Query("SELECT f FROM Food f " +
            "LEFT JOIN f.foodCategory fc " +
            "WHERE LOWER(f.name) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "   OR LOWER(fc.name) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Food> searchFood(@Param("keyword") String keyword);
}
