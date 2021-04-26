package com.peregud.pizza.controller;

import com.peregud.pizza.service.EmployeeService;
import com.peregud.pizza.util.CheckScannerInputUtil;
import com.peregud.pizza.view.EmployeeView;
import com.peregud.pizza.view.EmployeeViewConsole;

import java.util.ArrayList;
import java.util.List;

public class EmployeeController {
    private static final EmployeeView EMPLOYEE_VIEW;
    private static final EmployeeService EMPLOYEE_SERVICE;
    private static boolean programOn;
    private static final List<EmployeeService> EMPLOYEE_LIST;

    static {
        EMPLOYEE_VIEW = new EmployeeViewConsole();
        EMPLOYEE_SERVICE = new EmployeeService();
        programOn = true;
        EMPLOYEE_LIST = new ArrayList<>();
    }

    public void start() {
        EMPLOYEE_SERVICE.createNewEmployee(EMPLOYEE_LIST);
        EMPLOYEE_VIEW.selectOption();
        EMPLOYEE_VIEW.operationsMenu();
        while (programOn) {
            EMPLOYEE_VIEW.showMenu();
            int userMenuOption = CheckScannerInputUtil.checkInt();
            double amount;
            switch (userMenuOption) {
                case 1:
                    EMPLOYEE_SERVICE.createNewEmployee(EMPLOYEE_LIST);
                    break;
                case 2:
                    EMPLOYEE_VIEW.idForChangingSalary();
                    int employeeID = CheckScannerInputUtil.checkInt();
                    if (employeeID > EMPLOYEE_LIST.size()) {
                        EMPLOYEE_VIEW.notValidID();
                        break;
                    } else {
                        employeeID -= 1;
                        EMPLOYEE_VIEW.changeSalary();
                        amount = CheckScannerInputUtil.checkDouble();
                    }
                    EMPLOYEE_LIST.get(employeeID).salaryChange(amount);
                    break;
                case 3:
                    EMPLOYEE_SERVICE.getInfo(EMPLOYEE_LIST);
                    break;
                case 4:
                    EMPLOYEE_SERVICE.quitEmployee(EMPLOYEE_LIST);
                    break;
                case 5:
                    EMPLOYEE_VIEW.operationsMenu();
                    break;
                case 6:
                    programOn = false;
                    break;
            }
        }
    }
}
