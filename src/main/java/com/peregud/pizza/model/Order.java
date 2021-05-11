/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.model;

import com.peregud.pizza.annotations.DBFieldName;
import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Order implements Serializable {
    @DBFieldName(key = "order_id")
    private int id;
    @DBFieldName(key = "pizza")
    private String pizza;
    @DBFieldName(key = "price")
    private Double price;
    @DBFieldName(key = "order_time")
    private String orderTime;

    public Order(String pizza, Double price, String orderTime) {
        this.pizza = pizza;
        this.price = price;
        this.orderTime = orderTime;
    }

    public Order add(String pizza, double price, String orderTime) {
        return new Order(pizza, price, orderTime);
    }
}
