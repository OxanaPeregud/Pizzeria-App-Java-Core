/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.exceptions;

public class OrderStatisticsException extends Exception {

    public String toString() {
        return "Invalid number of sold pizzas";
    }
}
