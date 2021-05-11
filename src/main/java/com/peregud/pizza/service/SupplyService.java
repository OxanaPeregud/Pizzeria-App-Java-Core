/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.service;

import com.peregud.pizza.types.Supplier;
import com.peregud.pizza.repository.StorageRepository;
import com.peregud.pizza.util.CheckScannerInputUtil;
import com.peregud.pizza.view.SupplyServiceView;
import com.peregud.pizza.view.SupplyServiceViewConsole;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SupplyService {
    private static final Map<Integer, Supplier> SUPPLIERS;
    private final StorageRepository storage = new StorageRepository();
    private final SupplyServiceView supplyServiceView = new SupplyServiceViewConsole();

    static {
        SUPPLIERS = new HashMap<>();
        SUPPLIERS.put(1, Supplier.SUPPLIER_1);
        SUPPLIERS.put(2, Supplier.SUPPLIER_2);
        SUPPLIERS.put(3, Supplier.SUPPLIER_3);
        SUPPLIERS.put(4, Supplier.SUPPLIER_4);
        SUPPLIERS.put(5, Supplier.SUPPLIER_5);
        SUPPLIERS.put(6, Supplier.SUPPLIER_6);
        SUPPLIERS.put(7, Supplier.SUPPLIER_7);
        SUPPLIERS.put(8, Supplier.SUPPLIER_8);
    }

    public void start() {
        supplyServiceView.suppliersMenu();
        int supplierChoice = CheckScannerInputUtil.checkInt();
        if (SUPPLIERS.get(supplierChoice) != null) {
            switch (SUPPLIERS.get(supplierChoice)) {
                case SUPPLIER_1:
                    chooseSupplier(Supplier.SUPPLIER_1);
                    addChoiceQuestion();
                    break;
                case SUPPLIER_2:
                    chooseSupplier(Supplier.SUPPLIER_2);
                    addChoiceQuestion();
                    break;
                case SUPPLIER_3:
                    chooseSupplier(Supplier.SUPPLIER_3);
                    addChoiceQuestion();
                    break;
                case SUPPLIER_4:
                    chooseSupplier(Supplier.SUPPLIER_4);
                    addChoiceQuestion();
                    break;
                case SUPPLIER_5:
                    chooseSupplier(Supplier.SUPPLIER_5);
                    addChoiceQuestion();
                    break;
                case SUPPLIER_6:
                    chooseSupplier(Supplier.SUPPLIER_6);
                    addChoiceQuestion();
                    break;
                case SUPPLIER_7:
                    chooseSupplier(Supplier.SUPPLIER_7);
                    addChoiceQuestion();
                    break;
                case SUPPLIER_8:
                    chooseSupplier(Supplier.SUPPLIER_8);
                    addChoiceQuestion();
                    break;
            }
        } else {
            supplyServiceView.supplierNumberException();
            addChoiceQuestion();
        }
    }

    public void chooseSupplier(Supplier supplier) {
        supplyServiceView.supplierIngredientBefore(supplier);
        supplyServiceView.supplierDeliveredQuantity();
        storage.changeDeliveredIngredient(supplier);
        supplyServiceView.supplierIngredientAfter(supplier);
    }

    public void addChoiceQuestion() {
        supplyServiceView.chooseOtherSupplier();
        Scanner scan = new Scanner(System.in);
        char ch = scan.next().charAt(0);
        if (ch == 'Y' || ch == 'y') {
            start();
        }
    }
}
