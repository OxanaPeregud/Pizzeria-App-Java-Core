/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Supplier {
    SUPPLIER_1(Ingredient.CHEESE),
    SUPPLIER_2(Ingredient.MEAT),
    SUPPLIER_3(Ingredient.OLIVES),
    SUPPLIER_4(Ingredient.OREGANO),
    SUPPLIER_5(Ingredient.PEPPER),
    SUPPLIER_6(Ingredient.SAUCE),
    SUPPLIER_7(Ingredient.SAUSAGES),
    SUPPLIER_8(Ingredient.TOMATOES);
    private final Ingredient ingredient;
}
