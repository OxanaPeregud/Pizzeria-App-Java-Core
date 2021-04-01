package com.peregud.pizza.view;

public class UtilViewConsole implements UtilView {

    public void choiceUtilView() {
        System.out.println("You need to enter a number from 1 to 3");
    }

    public void checkUtilView() {
        System.out.println("Your input is invalid. You must enter a digit");
    }
}
