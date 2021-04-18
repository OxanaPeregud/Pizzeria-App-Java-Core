package com.peregud.pizza.view;

import com.peregud.pizza.exceptions.PaymentChoiceException;

public class PaymentViewConsole implements PaymentView {
    private static final PaymentChoiceException PAYMENT_CHOICE_EXCEPTION;

    static {
        PAYMENT_CHOICE_EXCEPTION = new PaymentChoiceException();
    }

    @Override
    public void paymentChoice() {
        System.out.println("How would you like to pay:");
        System.out.println("1. Cash");
        System.out.println("2. Credit card");
        System.out.println("3. Online");
    }

    @Override
    public void paymentChoiceException() {
        System.out.println(PAYMENT_CHOICE_EXCEPTION.toString());
    }
}
