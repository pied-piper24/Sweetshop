package com.sweetshop;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class Menu {
    private List<MenuItem> items;

    public Menu() {
        this.items = new ArrayList<>();
        initializeMenu();
    }

    private void initializeMenu() {
        // Add sweet items
        items.add(new MenuItem("Laddu", 10.0, "Sweet"));
        items.add(new MenuItem("Barfi", 15.0, "Sweet"));
        items.add(new MenuItem("Jalebi", 12.0, "Sweet"));

        // Add savory items
        items.add(new MenuItem("Samosa", 8.0, "Savory"));
        items.add(new MenuItem("Kachori", 10.0, "Savory"));
    }

    public List<MenuItem> getItems() {
        return new ArrayList<>(items);
    }

    public List<MenuItem> getItemsByCategory(String category) {
        List<MenuItem> categoryItems = new ArrayList<>();
        for (MenuItem item : items) {
            if (item.getCategory().equals(category)) {
                categoryItems.add(item);
            }
        }
        return categoryItems;
    }

    public Optional<MenuItem> getItemByName(String name) {
        return items.stream()
                .filter(item -> item.getName().equals(name))
                .findFirst();
    }
}