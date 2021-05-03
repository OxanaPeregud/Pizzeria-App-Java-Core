/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.view;

import java.sql.SQLException;

public interface EmployeeView {

    void employeeFirstName();

    void employeeLastName();

    void employeeSalary();

    void employeeID();

    void displayEmployeeByID(int id) throws SQLException;

    void setNewSalary();

    void changedSalary();

    void deleteEmployee();

    void displayAllEmployees() throws SQLException;

    void displayOperation();

    void displayChoice();

    void operationException();

    void choiceException();

}
