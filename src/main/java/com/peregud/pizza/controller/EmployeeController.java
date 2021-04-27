package com.peregud.pizza.controller;

import com.peregud.pizza.service.EmployeeService;
import com.peregud.pizza.util.CheckScannerInputUtil;
import com.peregud.pizza.view.EmployeeView;
import com.peregud.pizza.view.EmployeeViewConsole;

public class EmployeeController {
    private static final EmployeeView EMPLOYEE_VIEW;
    private static final EmployeeService EMPLOYEE;

    static {
        EMPLOYEE_VIEW = new EmployeeViewConsole();
        EMPLOYEE = new EmployeeService();
    }

    public void start() {
        EMPLOYEE_VIEW.displayChoice();
        int choice = CheckScannerInputUtil.checkInt();
        switch (choice) {
            case 1:
                EMPLOYEE.addNewEmployee();
                start();
                break;
            case 2:
                EMPLOYEE.displayEmployeeByID();
                start();
                break;
            case 3:
                EMPLOYEE.changeSalary();
                start();
                break;
            case 4:
                EMPLOYEE.deleteEmployee();
                start();
                break;
            case 5:
                EMPLOYEE.displayAllEmployees();
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
