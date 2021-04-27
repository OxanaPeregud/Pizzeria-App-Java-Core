package com.peregud.pizza.controller;

import com.peregud.pizza.service.EmployeeService;
import com.peregud.pizza.util.CheckScannerInputUtil;
import com.peregud.pizza.view.EmployeeView;
import com.peregud.pizza.view.EmployeeViewConsole;

public class EmployeeController {
    private static final EmployeeView EMPLOYEE_VIEW;
    private static final EmployeeService EMPLOYEE;
    private static final AddressController ADDRESS;

    static {
        EMPLOYEE_VIEW = new EmployeeViewConsole();
        EMPLOYEE = new EmployeeService();
        ADDRESS = new AddressController();
    }

    public void chooseOperation() {
        EMPLOYEE_VIEW.displayOperation();
        int choice = CheckScannerInputUtil.checkInt();
        switch (choice) {
            case 1:
                start();
                break;
            case 2:
                ADDRESS.start();
                break;
            default:
                EMPLOYEE_VIEW.operationException();
                chooseOperation();
                break;
        }
    }

    public void start() {
        EMPLOYEE_VIEW.displayChoice();
        int choice = CheckScannerInputUtil.checkInt();
        switch (choice) {
            case 1:
                EMPLOYEE.saveNewData();
                start();
                break;
            case 2:
                EMPLOYEE.getByID();
                start();
                break;
            case 3:
                EMPLOYEE.updateData();
                start();
                break;
            case 4:
                EMPLOYEE.deleteData();
                start();
                break;
            case 5:
                EMPLOYEE.displayAll();
                start();
                break;
            case 6:
                break;
            default:
                EMPLOYEE_VIEW.choiceException();
                start();
                break;
        }
    }
}
