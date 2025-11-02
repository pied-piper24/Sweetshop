package com.sweetshop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {
    private Cart cart;
    private Menu menu;

    @BeforeEach
    public void setUp() {
        menu = new Menu();
        cart = new Cart(menu);
    }

    @Test
    public void testOrderCreation() {
        cart.addItem("Laddu");
        cart.addItem("Samosa");

        Order order = new Order(cart);

        assertEquals(1, order.getOrderId());
        assertEquals(2, order.getItems().size());
        assertEquals(18.0, order.getTotalAmount(), 0.001);
    }
}
