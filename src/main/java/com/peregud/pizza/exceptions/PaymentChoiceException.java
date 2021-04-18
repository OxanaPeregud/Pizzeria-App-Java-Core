package com.peregud.pizza.exceptions;

public class PaymentChoiceException extends Exception {

    public String toString() {
        return "Invalid choice of payment method";
    }
}
