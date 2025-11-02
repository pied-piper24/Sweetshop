package com.sweetshop;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class Cart {
    private final Menu menu;
    private List<MenuItem> items;
    private double totalAmount;

    public Cart(Menu menu) {
        this.menu = menu;
        this.items = new ArrayList<>();
        this.totalAmount = 0.0;
    }

    public void addItem(String itemName) {
        Optional<MenuItem> item = menu.getItems().stream()
                .filter(menuItem -> menuItem.getName().equals(itemName))
                .findFirst();

        item.ifPresent(menuItem -> {
            items.add(menuItem);
            totalAmount += menuItem.getPrice();
        });
    }

    public void removeItem(String itemName) {
        Optional<MenuItem> item = items.stream()
                .filter(menuItem -> menuItem.getName().equals(itemName))
                .findFirst();

        item.ifPresent(menuItem -> {
            items.remove(menuItem);
            totalAmount -= menuItem.getPrice();
        });
    }

    public List<MenuItem> getItems() {
        return new ArrayList<>(items);
    }

    public double getTotal() {
        return totalAmount;
    }

    public void clear() {
        items.clear();
        totalAmount = 0.0;
    }
}