package com.peregud.pizza.view;

import com.peregud.pizza.model.Order;

import java.util.List;

public class SoldPizzasViewConsole implements SoldPizzasView {

    @Override
    public void displaySoldPizzas(List<Order> list) {
        if (list != null) {
            for (Order order : list) {
                System.out.println(order.getPizza() +
                        "\tPrice: " + order.getPrice() +
                        "\tOrder time: " + order.getOrderTime());
            }
        }
    }
}
