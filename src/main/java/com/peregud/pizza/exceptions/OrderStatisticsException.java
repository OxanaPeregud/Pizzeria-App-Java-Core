package com.peregud.pizza.exceptions;

public class OrderStatisticsException extends Exception {

    public String toString() {
        return "Invalid number of sold pizzas";
    }
}
