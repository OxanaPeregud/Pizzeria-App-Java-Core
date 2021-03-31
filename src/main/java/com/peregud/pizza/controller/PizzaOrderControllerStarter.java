package com.peregud.pizza.controller;

import com.peregud.pizza.service.PizzaOrderService;

import java.io.IOException;

public class PizzaOrderControllerStarter {
    public static void main(String[] args) throws IOException {
        PizzaOrderService pizzaOrderService = new PizzaOrderService();
        pizzaOrderService.start();
        pizzaOrderService.choosePizza();
        pizzaOrderService.addPizzaQuestion();
    }
}