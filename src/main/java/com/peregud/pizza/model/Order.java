package com.peregud.pizza.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Order implements Serializable {
    private String pizza;
    private double price;
    private String orderTime;

    public Order add(String pizza, double price, String orderTime) {
        return new Order(pizza, price, orderTime);
    }
}
