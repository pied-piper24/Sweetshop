package com.sweetshop;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderId;
    private List<MenuItem> items;
    private double totalAmount;
    private static int orderCounter = 1;

    public Order(Cart cart) {
        this.orderId = orderCounter++;
        this.items = new ArrayList<>(cart.getItems());
        this.totalAmount = cart.getTotal();
    }

    public int getOrderId() {
        return orderId;
    }

    public List<MenuItem> getItems() {
        return new ArrayList<>(items);
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}