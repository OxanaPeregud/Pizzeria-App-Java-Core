package com.peregud.pizza.view;

import com.peregud.pizza.util.CheckUtil;

public class CheckViewConsole implements CheckView {

    @Override
    public void displayCheck() {
        System.out.println("Your order includes:");
        CheckUtil.getCheck().forEach(System.out::println);
    }
}
