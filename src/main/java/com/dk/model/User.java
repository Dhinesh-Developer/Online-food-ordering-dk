package com.dk.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private USER_ROLE role = USER_ROLE.ROLE_CUSTOMER;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<Order> orders = new ArrayList<>();

    // Store actual Restaurant entities for favorites
    @ManyToMany
    @JoinTable(
            name = "user_favorites",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "restaurant_id")
    )
    private List<Restaurant> favourites = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses = new ArrayList<>();

    public User(String email, String password, USER_ROLE role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public User(String fullName, String email, String password, USER_ROLE role, List<Order> orders, List<Restaurant> favourites, List<Address> addresses) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.orders = orders;
        this.favourites = favourites;
        this.addresses = addresses;
    }

    public User(Long id, String fullName, String email, String password, USER_ROLE role, List<Order> orders, List<Restaurant> favourites, List<Address> addresses) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.orders = orders;
        this.favourites = favourites;
        this.addresses = addresses;
    }

    public User() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public USER_ROLE getRole() {
        return role;
    }

    public void setRole(USER_ROLE role) {
        this.role = role;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Restaurant> getFavourites() {
        return favourites;
    }

    public void setFavourites(List<Restaurant> favourites) {
        this.favourites = favourites;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(fullName, user.fullName) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && role == user.role && Objects.equals(orders, user.orders) && Objects.equals(favourites, user.favourites) && Objects.equals(addresses, user.addresses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, email, password, role, orders, favourites, addresses);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", orders=" + orders +
                ", favourites=" + favourites +
                ", addresses=" + addresses +
                '}';
    }
}
