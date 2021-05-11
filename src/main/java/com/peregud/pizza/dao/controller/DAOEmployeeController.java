/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.dao.controller;

import com.peregud.pizza.model.Employee;
import com.peregud.pizza.dao.DAOEmployee;
import com.peregud.pizza.dao.impl.DAOEmployeeSQLImpl;
import com.peregud.pizza.view.EmployeeView;
import com.peregud.pizza.view.EmployeeViewConsole;

import java.sql.SQLException;
import java.util.Scanner;

public class DAOEmployeeController implements DBData {
    private final EmployeeView employeeView = new EmployeeViewConsole();
    private final Scanner scan = new Scanner(System.in);
    private final DAOEmployee daoEmployee = new DAOEmployeeSQLImpl();
    private final Employee employee = new Employee();

    @Override
    public void saveNewData() {
        try {
            employeeView.employeeFirstName();
            String firstName = scan.next();
            employeeView.employeeLastName();
            String lastName = scan.next();
            employeeView.employeeSalary();
            double salary = scan.nextDouble();
            new Employee();
            daoEmployee.save(Employee.builder()
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
            employeeView.employeeID();
            int id = scan.nextInt();
            employeeView.displayEmployeeByID(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void updateData() {
        try {
            employeeView.employeeID();
            int id = scan.nextInt();
            employeeView.displayEmployeeByID(id);
            employeeView.setNewSalary();
            double salary = scan.nextDouble();
            employee.setSalary(salary);
            employee.setId(id);
            daoEmployee.update(employee);
            employeeView.changedSalary();
            employeeView.displayEmployeeByID(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteData() {
        try {
            employeeView.employeeID();
            int id = scan.nextInt();
            daoEmployee.delete(id);
            employeeView.deleteEmployee();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void displayAll() {
        try {
            employeeView.displayAllEmployees();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
