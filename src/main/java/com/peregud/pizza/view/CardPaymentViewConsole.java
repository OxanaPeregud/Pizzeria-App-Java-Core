/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.view;

public class CardPaymentViewConsole implements CardPaymentView {

    @Override
    public void enterPIN() {
        System.out.println("Enter PIN:");
    }

    @Override
    public void invalidInput() {
        System.out.println("PIN must contain 4 digits");
    }

    @Override
    public void approvePayment() {
        System.out.println("Payment approved");
    }

    @Override
    public void pinException() {
        System.out.println("PIN must contain only digits");
    }
}
