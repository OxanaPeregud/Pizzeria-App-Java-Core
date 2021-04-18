package com.peregud.pizza.view;

public class PaymentViewConsole implements PaymentView {

    @Override
    public void paymentChoice() {
        System.out.println("How would you like to pay:");
        System.out.println("1. Cash");
        System.out.println("2. Credit card");
        System.out.println("3. Online");
    }

    @Override
    public void paymentChoiceException() {
        System.out.println("To choose a payment method you need to enter a number from 1 to 3");
    }
}
