package com.peregud.pizza.view;

import com.peregud.pizza.exceptions.PinException;

public class CardPaymentViewConsole implements CardPaymentView {
    private static final PinException PIN_EXCEPTION;

    static {
        PIN_EXCEPTION = new PinException();
    }

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
        System.out.println(PIN_EXCEPTION.toString());
    }
}
