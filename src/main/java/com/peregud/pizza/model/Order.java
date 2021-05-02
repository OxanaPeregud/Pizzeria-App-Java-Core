package com.peregud.pizza.model;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class Order implements Serializable {
    private int id;
    private @NonNull String pizza;
    private @NonNull Double price;
    private @NonNull String orderTime;

    public Order add(String pizza, double price, String orderTime) {
        return new Order(pizza, price, orderTime);
    }
}
