package com.sweetshop.controller;

import com.sweetshop.Cart;
import com.sweetshop.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "http://localhost:3000")
public class OrderController {
    private final Cart cart;
    private final Map<Integer, Order> orders = new ConcurrentHashMap<>();

    public OrderController(Cart cart) {
        this.cart = cart;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> createOrder() {
        if (cart.getItems().isEmpty()) {
            return ResponseEntity.badRequest()
                    .body(Map.of("error", "Cannot create order with empty cart"));
        }

        Order order = new Order(cart);
        orders.put(order.getOrderId(), order);

        // Clear the cart after successful order creation
        cart.clear();

        Map<String, Object> response = new HashMap<>();
        response.put("orderId", order.getOrderId());
        response.put("items", order.getItems());
        response.put("totalAmount", order.getTotalAmount());
        response.put("status", "Order placed successfully");

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Map<String, Object>> getOrder(@PathVariable int orderId) {
        Order order = orders.get(orderId);
        if (order == null) {
            return ResponseEntity.notFound().build();
        }

        Map<String, Object> response = new HashMap<>();
        response.put("orderId", order.getOrderId());
        response.put("items", order.getItems());
        response.put("totalAmount", order.getTotalAmount());
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<Map<String, Object>>> getAllOrders() {
        List<Map<String, Object>> orderList = new ArrayList<>();

        for (Order order : orders.values()) {
            Map<String, Object> orderMap = new HashMap<>();
            orderMap.put("orderId", order.getOrderId());
            orderMap.put("items", order.getItems());
            orderMap.put("totalAmount", order.getTotalAmount());
            orderList.add(orderMap);
        }

        return ResponseEntity.ok(orderList);
    }
}