package com.peregud.pizza.view;

import com.peregud.pizza.service.CreatePizzaService;
import com.peregud.pizza.service.PizzaOrderService;

public class CheckViewConsole implements CheckView {

    @Override
    public void displayCheckPizzaOrder() {
        PizzaOrderService.CHECK.getItemsInCheck().forEach(System.out::println);
    }

    @Override
    public void displayCheckCreatePizza() {
        CreatePizzaService.CHECK.getItemsInCheck().forEach(System.out::println);
    }
}
