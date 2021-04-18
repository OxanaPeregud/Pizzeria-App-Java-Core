package com.peregud.pizza.model;

import java.io.Serializable;

public class Order implements Serializable {
    private String pizza;
    private double price;
    private String orderTime;

    public Order() {
    }

    public Order(String pizza, double price, String orderTime) {
        this.pizza = pizza;
        this.price = price;
        this.orderTime = orderTime;
    }

    public Order add(String pizza, double price, String orderTime) {
        return new Order(pizza, price, orderTime);
    }

    public String getPizza() {
        return pizza;
    }

    public double getPrice() {
        return price;
    }

    public String getOrderTime() {
        return orderTime;
    }
}
