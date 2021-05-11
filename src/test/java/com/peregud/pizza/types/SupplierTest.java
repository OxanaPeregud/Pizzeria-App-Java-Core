/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.types;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SupplierTest {

    @Test
    public void getIngredient_Supplier1() {
        assertEquals(Ingredient.CHEESE, Supplier.SUPPLIER_1.getIngredient());
    }

    @Test
    public void getIngredient_Supplier2() {
        assertEquals(Ingredient.MEAT, Supplier.SUPPLIER_2.getIngredient());
    }

    @Test
    public void getIngredient_Supplier3() {
        assertEquals(Ingredient.OLIVES, Supplier.SUPPLIER_3.getIngredient());
    }

    @Test
    public void getIngredient_Supplier4() {
        assertEquals(Ingredient.OREGANO, Supplier.SUPPLIER_4.getIngredient());
    }

    @Test
    public void getIngredient_Supplier5() {
        assertEquals(Ingredient.PEPPER, Supplier.SUPPLIER_5.getIngredient());
    }

    @Test
    public void getIngredient_Supplier6() {
        assertEquals(Ingredient.SAUCE, Supplier.SUPPLIER_6.getIngredient());
    }

    @Test
    public void getIngredient_Supplier7() {
        assertEquals(Ingredient.SAUSAGES, Supplier.SUPPLIER_7.getIngredient());
    }

    @Test
    public void getIngredient_Supplier8() {
        assertEquals(Ingredient.TOMATOES, Supplier.SUPPLIER_8.getIngredient());
    }
}
