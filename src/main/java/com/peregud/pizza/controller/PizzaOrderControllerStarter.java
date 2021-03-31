package com.peregud.pizza.controller;

import com.peregud.pizza.service.PizzaOrderService;

public class PizzaOrderControllerStarter {
    public static void main(String[] args) {
        PizzaOrderService pizzaOrderService = new PizzaOrderService();
        pizzaOrderService.start();
        pizzaOrderService.choosePizza();
    }
}
