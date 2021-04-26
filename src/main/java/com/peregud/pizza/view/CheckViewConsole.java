package com.peregud.pizza.view;

import com.peregud.pizza.model.Check;

public class CheckViewConsole implements CheckView {

    @Override
    public void displayCheck() {
        System.out.println("Your order includes:");
        Check.getCheck().forEach(System.out::println);
    }
}
