package com.peregud.pizza.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Ingredient {
    CHEESE(2.50, 360),
    MEAT(5.20, 220),
    OLIVES(2.50, 115),
    OREGANO(1.10, 10),
    PEPPER(1.80, 30),
    SAUCE(1.00, 50),
    SAUSAGES(6.00, 320),
    THIN_DOUGH(1.90, 150),
    TOMATOES(1.50, 20),
    TRADITIONAL_DOUGH(2.50, 250);
    private final double costPerUnit;
    private final int calories;
}
