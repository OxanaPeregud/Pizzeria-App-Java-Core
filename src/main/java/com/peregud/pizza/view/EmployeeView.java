package com.peregud.pizza.view;

import com.peregud.pizza.service.EmployeeService;

import java.util.List;

public interface EmployeeView {

    void employeeSalaryChange();

    void quitEmployee();

    void notValidID();

    void employeeInfo();

    void employeeDisplay(List<EmployeeService> employeeList);

    void employeeQuantity();

    void employeeFirstName();

    void employeeLastName();

    void employeeSalary();

    void operationsMenu();

    void selectOption();

    void idForChangingSalary();

    void changeSalary();

    void exitProgram();

    void showMenu();

}
