//package com.example.sara.loginregistera.model;
//
//import jakarta.persistence.*;
//import java.util.HashMap;
//import java.util.Map;
//
//@Entity
//public class Order {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "user_id", nullable = false)
//    private User user;
//
//    @ElementCollection
//    @CollectionTable(name = "order_items", joinColumns = @JoinColumn(name = "order_id"))
//    @MapKeyColumn(name = "food_item_id")
//    @Column(name = "quantity")
//    private Map<Long, Integer> items = new HashMap<>(); // FoodItem ID -> Quantity
//
//    private double totalPrice;
//
//    // Getters and Setters
//    public Long getId() { return id; }
//    public void setId(Long id) { this.id = id; }
//    public User getUser() { return user; }
//    public void setUser(User user) { this.user = user; }
//    public Map<Long, Integer> getItems() { return items; }
//    public void setItems(Map<Long, Integer> items) { this.items = items; }
//    public double getTotalPrice() { return totalPrice; }
//    public void setTotalPrice(double totalPrice) { this.totalPrice = totalPrice; }
//}