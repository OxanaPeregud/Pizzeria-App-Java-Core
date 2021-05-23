/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.view;

public class UtilViewConsole implements UtilView {

    @Override
    public void choiceUtilView() {
        System.out.println("You need to enter a number from 1 to 3");
    }

    @Override
    public String checkUtilView() {
        return "Your input is invalid. You must enter a digit";
    }
}
