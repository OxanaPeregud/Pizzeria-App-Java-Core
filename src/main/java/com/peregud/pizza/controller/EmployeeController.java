/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.controller;

import com.peregud.pizza.dao.service.DAOEmployeeService;
import com.peregud.pizza.util.CheckScannerInputUtil;
import com.peregud.pizza.view.EmployeeView;
import com.peregud.pizza.view.EmployeeViewConsole;

public class EmployeeController {
    private final EmployeeView employeeView = new EmployeeViewConsole();
    private final DAOEmployeeService employee = new DAOEmployeeService();
    private final AddressController address = new AddressController();

    public void chooseOperation() {
        employeeView.displayOperation();
        int choice = CheckScannerInputUtil.checkInt();
        switch (choice) {
            case 1:
                start();
                break;
            case 2:
                address.start();
                break;
            default:
                employeeView.operationException();
                chooseOperation();
                break;
        }
    }

    public void start() {
        employeeView.displayChoice();
        int choice = CheckScannerInputUtil.checkInt();
        switch (choice) {
            case 1:
                employee.saveNewData();
                start();
                break;
            case 2:
                employee.getByID();
                start();
                break;
            case 3:
                employee.updateData();
                start();
                break;
            case 4:
                employee.deleteData();
                start();
                break;
            case 5:
                employee.displayAll();
                start();
                break;
            case 6:
                break;
            default:
                employeeView.choiceException();
                start();
                break;
        }
    }
}
