package com.sweetshop.controller;

import com.sweetshop.Cart;
import com.sweetshop.MenuItem;
import com.sweetshop.Menu;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin(origins = "http://localhost:3000")
public class CartController {
    private final Cart cart;
    private final Menu menu;

    public CartController(Cart cart, Menu menu) {
        this.cart = cart;
        this.menu = menu;
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> getCartItems() {
        Map<String, Object> response = new HashMap<>();
        response.put("items", cart.getItems());
        response.put("total", cart.getTotal());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/total")
    public ResponseEntity<Map<String, Object>> getCartTotal() {
        Map<String, Object> response = new HashMap<>();
        response.put("total", cart.getTotal());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/items/{itemName}")
    public ResponseEntity<Map<String, Object>> addItem(@PathVariable String itemName) {
        Optional<MenuItem> menuItem = menu.getItemByName(itemName);
        if (menuItem.isEmpty()) {
            Map<String, Object> error = new HashMap<>();
            error.put("error", "Item not found: " + itemName);
            return ResponseEntity.badRequest().body(error);
        }

        cart.addItem(itemName);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Item added to cart: " + itemName);
        response.put("items", cart.getItems());
        response.put("total", cart.getTotal());
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/items/{itemName}")
    public ResponseEntity<Map<String, Object>> removeItem(@PathVariable String itemName) {
        List<MenuItem> cartItems = cart.getItems();
        boolean itemExists = cartItems.stream()
                .anyMatch(item -> item.getName().equals(itemName));

        if (!itemExists) {
            Map<String, Object> error = new HashMap<>();
            error.put("error", "Item not found in cart: " + itemName);
            return ResponseEntity.badRequest().body(error);
        }

        cart.removeItem(itemName);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Item removed from cart: " + itemName);
        response.put("items", cart.getItems());
        response.put("total", cart.getTotal());
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/clear")
    public ResponseEntity<Map<String, Object>> clearCart() {
        if (cart.getItems().isEmpty()) {
            Map<String, Object> error = new HashMap<>();
            error.put("error", "Cart is already empty");
            return ResponseEntity.badRequest().body(error);
        }

        cart.clear();

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Cart cleared successfully");
        response.put("items", cart.getItems());
        response.put("total", cart.getTotal());
        return ResponseEntity.ok(response);
    }
}