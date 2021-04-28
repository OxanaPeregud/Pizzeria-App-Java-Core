package com.peregud.pizza.view;

import java.sql.SQLException;

public interface EmployeeAddressView {

    void employeeAddress();

    void changedAddressID();

    void deleteEmployeeAddressData();

    void displayAllEmployeesAddress() throws SQLException;

    void displayChoice();

    void choiceException();

    void displayEmployeeAddressByID(int id) throws SQLException;

}
