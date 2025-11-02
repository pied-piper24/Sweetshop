package com.sweetshop.controller;

import com.sweetshop.MenuItem;
import com.sweetshop.Menu;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menu")
@CrossOrigin(origins = "http://localhost:3000")
public class MenuController {
    private final Menu menu;

    public MenuController(Menu menu) {
        this.menu = menu;
    }

    @GetMapping
    public ResponseEntity<List<MenuItem>> getAllItems() {
        return ResponseEntity.ok(menu.getItems());
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<MenuItem>> getItemsByCategory(@PathVariable String category) {
        return ResponseEntity.ok(menu.getItemsByCategory(category));
    }
}