/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.model;

import com.peregud.pizza.annotations.DBFieldName;
import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class Order implements Serializable {
    @DBFieldName(key = "order_id")
    private int id;
    @DBFieldName(key = "pizza")
    private @NonNull String pizza;
    @DBFieldName(key = "price")
    private @NonNull Double price;
    @DBFieldName(key = "order_time")
    private @NonNull String orderTime;

    public Order add(String pizza, double price, String orderTime) {
        return new Order(pizza, price, orderTime);
    }
}
