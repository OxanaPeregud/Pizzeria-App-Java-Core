package com.peregud.pizza.view;

import com.peregud.pizza.exceptions.CardException;
import com.peregud.pizza.model.Customer;

public class OnlinePaymentViewConsole implements OnlinePaymentView {
    private static final CardException CARD_EXCEPTION;

    static {
        CARD_EXCEPTION = new CardException();
    }

    @Override
    public void firstName() {
        System.out.println("Enter your First Name:");
    }

    @Override
    public void lastName() {
        System.out.println("Enter your Last Name:");
    }

    @Override
    public void cardNumber() {
        System.out.println("Enter your Card Number:");
    }

    @Override
    public void invalidInput() {
        System.out.println("Card Number must contain 16 digits");
    }

    @Override
    public void displayPayment() {
        System.out.println(Customer.firstName + " " + Customer.lastName + " paid total amount");
    }

    @Override
    public void cardException() {
        System.out.println(CARD_EXCEPTION.toString());
    }
}
