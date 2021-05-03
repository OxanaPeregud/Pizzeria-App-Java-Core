/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.controller;

import com.peregud.pizza.service.EmployeeAddressService;
import com.peregud.pizza.util.CheckScannerInputUtil;
import com.peregud.pizza.view.EmployeeAddressView;
import com.peregud.pizza.view.EmployeeAddressViewConsole;

public class EmployeeAddressController {
    private static final EmployeeAddressService EMPLOYEE_ADDRESS;
    private static final EmployeeAddressView EMPLOYEE_ADDRESS_VIEW;

    static {
        EMPLOYEE_ADDRESS = new EmployeeAddressService();
        EMPLOYEE_ADDRESS_VIEW = new EmployeeAddressViewConsole();
    }

    public void start() {
        EMPLOYEE_ADDRESS_VIEW.displayChoice();
        int choice = CheckScannerInputUtil.checkInt();
        switch (choice) {
            case 1:
                EMPLOYEE_ADDRESS.saveNewData();
                start();
                break;
            case 2:
                EMPLOYEE_ADDRESS.getByID();
                start();
                break;
            case 3:
                EMPLOYEE_ADDRESS.updateData();
                start();
                break;
            case 4:
                EMPLOYEE_ADDRESS.deleteData();
                start();
                break;
            case 5:
                EMPLOYEE_ADDRESS.displayAll();
                start();
                break;
            case 6:
                break;
            default:
                EMPLOYEE_ADDRESS_VIEW.choiceException();
                start();
                break;
        }
    }
}
