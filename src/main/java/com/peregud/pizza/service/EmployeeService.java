/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.service;

import com.peregud.pizza.model.Employee;
import com.peregud.pizza.repository.EmployeeAddressRepository;
import com.peregud.pizza.repository.EmployeeAddressRepositorySQLImpl;
import com.peregud.pizza.repository.EmployeeRepository;
import com.peregud.pizza.repository.EmployeeRepositorySQLImpl;
import com.peregud.pizza.view.EmployeeView;
import com.peregud.pizza.view.EmployeeViewConsole;

import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeService implements DBData {
    private static final EmployeeView EMPLOYEE_VIEW;
    private static final Scanner SCAN;
    private static final EmployeeRepository EMPLOYEE_REPOSITORY;
    private final Employee employee = new Employee();
    private static final EmployeeAddressRepository EMPLOYEE_ADDRESS_REPOSITORY;

    static {
        EMPLOYEE_VIEW = new EmployeeViewConsole();
        SCAN = new Scanner(System.in);
        EMPLOYEE_REPOSITORY = new EmployeeRepositorySQLImpl();
        EMPLOYEE_ADDRESS_REPOSITORY = new EmployeeAddressRepositorySQLImpl();
    }

    @Override
    public void saveNewData() {
        try {
            EMPLOYEE_VIEW.employeeFirstName();
            String firstName = SCAN.next();
            EMPLOYEE_VIEW.employeeLastName();
            String lastName = SCAN.next();
            EMPLOYEE_VIEW.employeeSalary();
            double salary = SCAN.nextDouble();
            new Employee();
            EMPLOYEE_REPOSITORY.save(Employee.builder()
                    .firstName(firstName)
                    .lastName(lastName)
                    .salary(salary)
                    .build());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void getByID() {
        try {
            EMPLOYEE_VIEW.employeeID();
            int id = SCAN.nextInt();
            EMPLOYEE_VIEW.displayEmployeeByID(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void updateData() {
        try {
            EMPLOYEE_VIEW.employeeID();
            int id = SCAN.nextInt();
            EMPLOYEE_VIEW.displayEmployeeByID(id);
            EMPLOYEE_VIEW.setNewSalary();
            double salary = SCAN.nextDouble();
            employee.setSalary(salary);
            employee.setId(id);
            EMPLOYEE_REPOSITORY.update(employee);
            EMPLOYEE_VIEW.changedSalary();
            EMPLOYEE_VIEW.displayEmployeeByID(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteData() {
        try {
            EMPLOYEE_VIEW.employeeID();
            int id = SCAN.nextInt();
            EMPLOYEE_REPOSITORY.delete(id);
            EMPLOYEE_ADDRESS_REPOSITORY.delete(id);
            EMPLOYEE_VIEW.deleteEmployee();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void displayAll() {
        try {
            EMPLOYEE_VIEW.displayAllEmployees();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
