/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.view;

import com.peregud.pizza.dao.DAOEmployee;
import com.peregud.pizza.dao.impl.DAOEmployeeSQLImpl;

import java.sql.SQLException;

public class EmployeeViewConsole implements EmployeeView {
    private final DAOEmployee daoEmployee = new DAOEmployeeSQLImpl();

    @Override
    public void employeeFirstName() {
        System.out.println("Enter employee First Name:");
    }

    @Override
    public void employeeLastName() {
        System.out.println("Enter employee Last Name:");
    }

    @Override
    public void employeeSalary() {
        System.out.println("Enter employee salary:");
    }

    @Override
    public void employeeID() {
        System.out.println("Enter employee ID:");
    }

    @Override
    public void displayEmployeeByID(int id) throws SQLException {
        if (daoEmployee.get(id) != null) {
            System.out.println(daoEmployee.get(id));
        } else {
            System.out.println("There is no employee under entered ID");
        }
    }

    @Override
    public void setNewSalary() {
        System.out.println("Enter new salary:");
    }

    @Override
    public void changedSalary() {
        System.out.println("Employee salary has been changed");
    }

    @Override
    public void deleteEmployee() {
        System.out.println("Employee has been deleted");
    }

    @Override
    public void displayAllEmployees() throws SQLException {
        daoEmployee.getAll().forEach(System.out::println);
    }

    @Override
    public void displayOperation() {
        System.out.println("Choose option:");
        System.out.println("1. Go to Employee App");
        System.out.println("2. Go to Address App");
    }

    @Override
    public void displayChoice() {
        System.out.println("Choose option:");
        System.out.println("1. Add new Employee");
        System.out.println("2. Display Employee by ID");
        System.out.println("3. Change Employee Salary");
        System.out.println("4. Delete Employee");
        System.out.println("5. Display all Employees");
        System.out.println("6. Exit employee app");
    }

    @Override
    public void operationException() {
        System.out.println("You need to enter 1 or 2");
    }

    @Override
    public void choiceException() {
        System.out.println("You need to enter a number from 1 to 6");
    }
}
