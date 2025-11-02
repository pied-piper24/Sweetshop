package com.sweetshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SweetShopApplication {
    public static void main(String[] args) {
        SpringApplication.run(SweetShopApplication.class, args);
    }

    @Bean
    public Menu menu() {
        return new Menu();
    }

    @Bean
    public Cart cart(Menu menu) {
        return new Cart(menu);
    }
}