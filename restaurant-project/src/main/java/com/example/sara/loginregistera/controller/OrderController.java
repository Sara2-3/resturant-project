//package com.example.sara.loginregistera.controller;
//
//
//import com.example.sara.loginregistera.model.FoodItem;
//import com.example.sara.loginregistera.model.Order;
//import com.example.sara.loginregistera.model.User;
//import com.example.sara.loginregistera.repository.FoodItemRepository;
//import com.example.sara.loginregistera.service.OrderService;
//import com.example.sara.loginregistera.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.security.Principal;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Controller
//@RequestMapping("/order")
//public class OrderController {
//    @Autowired
//    private FoodItemRepository foodItemRepository;
//
//    @Autowired
//    private OrderService orderService;
//
//    @Autowired
//    private UserService userService;
//
//    @GetMapping("/form")
//    public String showOrderForm(Model model) {
//        List<FoodItem> starters = foodItemRepository.findByCategory("starter");
//        List<FoodItem> mainCourses = foodItemRepository.findByCategory("mainCourse");
//        List<FoodItem> desserts = foodItemRepository.findByCategory("dessert");
//        List<FoodItem> drinks = foodItemRepository.findByCategory("drink");
//
//        model.addAttribute("starters", starters);
//        model.addAttribute("mainCourses", mainCourses);
//        model.addAttribute("desserts", desserts);
//        model.addAttribute("drinks", drinks);
//
//        return "orderForm";
//    }
//
//    @PostMapping("/submit")
//    public String submitOrder(@RequestParam Map<Long, Integer> items, Principal principal) {
//        String username = principal.getName();
//        User user = userService.findByUsername(username);
//
//        Order order = orderService.createOrder(user, items);
//        return "redirect:/order/summary/" + order.getId();
//    }
//
//    @GetMapping("/summary/{orderId}")
//    public String showOrderSummary(@PathVariable Long orderId, Model model) {
//        Order order = orderService.findById(orderId);
//        model.addAttribute("order", order);
//        return "orderSummary";
//    }
//}