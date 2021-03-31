package com.peregud.pizza.exceptions;

public class CashAmountException extends Exception {

    public String toString() {
        return "Cash amount must be a number";
    }
}
