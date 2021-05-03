/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.view;

public class OnlinePaymentViewConsole implements OnlinePaymentView {

    @Override
    public void invalidInput() {
        System.out.println("Card Number must contain 16 digits");
    }

    @Override
    public void displayPayment() {
        System.out.println("Payment was successful");
    }

    @Override
    public void cardException() {
        System.out.println("Card Number must contain only digits");
    }
}
