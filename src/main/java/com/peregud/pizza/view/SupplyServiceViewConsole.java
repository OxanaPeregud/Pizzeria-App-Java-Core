/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.view;

import com.peregud.pizza.types.Supplier;
import com.peregud.pizza.repository.StorageRepository;

public class SupplyServiceViewConsole implements SupplyServiceView {
    private static final StorageRepository STORAGE = new StorageRepository();

    @Override
    public void suppliersMenu() {
        System.out.println("Choose supplier from which you got delivery:");
        System.out.println("1. Supplier_1");
        System.out.println("2. Supplier_2");
        System.out.println("3. Supplier_3");
        System.out.println("4. Supplier_4");
        System.out.println("5. Supplier_5");
        System.out.println("6. Supplier_6");
        System.out.println("7. Supplier_7");
        System.out.println("8. Supplier_8");
    }

    @Override
    public void supplierDeliveredQuantity() {
        System.out.println("Enter delivered quantity of ingredients from supplier");
    }

    @Override
    public void supplierIngredientBefore(Supplier supplier) {
        System.out.println(supplier + " delivered " + supplier.getIngredient());
        System.out.println("Current quantity of " + supplier.getIngredient() + " in storage: "
                + STORAGE.getIngredientQuantity(supplier.getIngredient()));
    }

    @Override
    public void supplierIngredientAfter(Supplier supplier) {
        System.out.println("Quantity of " + supplier.getIngredient() + " has been changed to: "
                + STORAGE.getIngredientQuantity(supplier.getIngredient()));
    }

    @Override
    public void chooseOtherSupplier() {
        System.out.println("\nDo you want to choose another supplier? (Type y or n)");
    }

    @Override
    public void invalidInput() {
        System.out.println("Your input is invalid. You must enter a digit");
    }

    @Override
    public void supplierNumberException() {
        System.out.println("There is no supplier under entered number");
    }
}
