/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.controller;

import com.peregud.pizza.service.AddressService;
import com.peregud.pizza.util.CheckScannerInputUtil;
import com.peregud.pizza.view.AddressView;
import com.peregud.pizza.view.AddressViewConsole;

public class AddressController {
    private final AddressView addressView = new AddressViewConsole();
    private final AddressService address = new AddressService();

    public void start() {
        addressView.displayChoice();
        int choice = CheckScannerInputUtil.checkInt();
        switch (choice) {
            case 1:
                address.saveNewData();
                start();
                break;
            case 2:
                address.getByID();
                start();
                break;
            case 3:
                address.updateData();
                start();
                break;
            case 4:
                address.deleteData();
                start();
                break;
            case 5:
                address.displayAll();
                start();
                break;
            case 6:
                break;
            default:
                addressView.choiceException();
                start();
                break;
        }
    }
}
