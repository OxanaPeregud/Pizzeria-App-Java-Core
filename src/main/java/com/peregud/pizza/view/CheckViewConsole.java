package com.peregud.pizza.view;

import com.peregud.pizza.model.Check;

public class CheckViewConsole implements CheckView {

    @Override
    public void displayCheckPizzaOrder() {
        Check.getCheck().forEach(System.out::println);
    }

    @Override
    public void displayCheckCreatePizza() {
        Check.getCheck().forEach(System.out::println);
    }
}
