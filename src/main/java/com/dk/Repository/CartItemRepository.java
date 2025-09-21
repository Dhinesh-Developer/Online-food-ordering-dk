package com.dk.Repository;
import com.dk.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface CartItemRepository extends JpaRepository<CartItem,Long> {
}
