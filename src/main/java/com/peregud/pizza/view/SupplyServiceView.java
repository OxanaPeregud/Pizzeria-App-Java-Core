/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.view;

import com.peregud.pizza.model.Supplier;

public interface SupplyServiceView {

    void suppliersMenu();

    void supplierDeliveredQuantity();

    void supplierIngredientBefore(Supplier supplier);

    void supplierIngredientAfter(Supplier supplier);

    void chooseOtherSupplier();

    void invalidInput();

    void supplierNumberException();

}
