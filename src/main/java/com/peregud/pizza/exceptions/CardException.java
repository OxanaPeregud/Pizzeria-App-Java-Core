package com.peregud.pizza.exceptions;

public class CardException extends Exception {

    public String toString() {
        return "Card Number must contain only digits";
    }
}
