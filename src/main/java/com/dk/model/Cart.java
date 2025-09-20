package com.dk.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private User customer;

    private Long total;

    @OneToMany(mappedBy = "cart" ,cascade = CascadeType.ALL,orphanRemoval = true)
    private List<CartItem> item = new ArrayList<>();

    public Cart() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<CartItem> getItem() {
        return item;
    }

    public void setItem(List<CartItem> item) {
        this.item = item;
    }

    public Cart(User customer, Long total, List<CartItem> item) {
        this.customer = customer;
        this.total = total;
        this.item = item;
    }

    public Cart(int id, User customer, Long total, List<CartItem> item) {
        this.id = id;
        this.customer = customer;
        this.total = total;
        this.item = item;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", customer=" + customer +
                ", total=" + total +
                ", item=" + item +
                '}';
    }
}
