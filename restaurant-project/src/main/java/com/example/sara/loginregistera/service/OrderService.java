//package com.example.sara.loginregistera.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import com.example.sara.loginregistera.repository.FoodItemRepository;
//import com.example.sara.loginregistera.repository.OrderRepository;
//import com.example.sara.loginregistera.model.FoodItem;
//import com.example.sara.loginregistera.model.Order;
//import com.example.sara.loginregistera.model.User;
//
//
//
//import java.util.Map;
//
//@Service
//public class OrderService {
//    @Autowired
//    private OrderRepository orderRepository;
//
//    @Autowired
//    private FoodItemRepository foodItemRepository;
//
//    public Order createOrder(User user, Map<Long, Integer> items) {
//        Order order = new Order();
//        order.setUser(user);
//        order.setItems(items);
//
//        double totalPrice = 0;
//        for (Map.Entry<Long, Integer> entry : items.entrySet()) {
//            FoodItem foodItem = foodItemRepository.findById(entry.getKey()).orElseThrow();
//            totalPrice += foodItem.getPrice() * entry.getValue();
//        }
//        order.setTotalPrice(totalPrice);
//
//        return orderRepository.save(order);
////    }
//}