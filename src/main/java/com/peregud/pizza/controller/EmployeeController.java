package com.peregud.pizza.controller;

import com.peregud.pizza.service.EmployeeService;
import com.peregud.pizza.util.CheckUtil;
import com.peregud.pizza.view.EmployeeViewConsole;

import java.util.ArrayList;
import java.util.List;

public class EmployeeController {
    private static final EmployeeViewConsole EMPLOYEE_VIEW;
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
            int userMenuOption = CheckUtil.checkInt();
            double amount;
            switch (userMenuOption) {
                case 1:
                    EMPLOYEE_SERVICE.createNewEmployee(EMPLOYEE_LIST);
                    break;
                case 2:
                    EMPLOYEE_VIEW.idForChangingSalary();
                    int employeeID = CheckUtil.checkInt();
                    if (employeeID > EMPLOYEE_LIST.size()) {
                        EMPLOYEE_VIEW.notValidID();
                        break;
                    } else {
                        employeeID -= 1;
                        EMPLOYEE_VIEW.changeSalary();
                        amount = CheckUtil.checkDouble();
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
                    EMPLOYEE_VIEW.exitProgram();
                    programOn = false;
                    break;
            }
        }
    }
}
