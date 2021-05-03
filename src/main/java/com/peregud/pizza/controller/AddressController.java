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
    private static final AddressView ADDRESS_VIEW;
    private static final AddressService ADDRESS;

    static {
        ADDRESS_VIEW = new AddressViewConsole();
        ADDRESS = new AddressService();
    }

    public void start() {
        ADDRESS_VIEW.displayChoice();
        int choice = CheckScannerInputUtil.checkInt();
        switch (choice) {
            case 1:
                ADDRESS.saveNewData();
                start();
                break;
            case 2:
                ADDRESS.getByID();
                start();
                break;
            case 3:
                ADDRESS.updateData();
                start();
                break;
            case 4:
                ADDRESS.deleteData();
                start();
                break;
            case 5:
                ADDRESS.displayAll();
                start();
                break;
            case 6:
                break;
            default:
                ADDRESS_VIEW.choiceException();
                start();
                break;
        }
    }
}
