package com.peregud.pizza.service;

import com.peregud.pizza.model.EmployeeAddress;
import com.peregud.pizza.repository.*;
import com.peregud.pizza.view.*;

import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeAddressService implements DBData {
    private static final EmployeeAddressView EMPLOYEE_ADDRESS_VIEW;
    private static final Scanner SCAN;
    private static final EmployeeAddressRepository EMPLOYEE_ADDRESS_REPOSITORY;
    private final EmployeeAddress employeeAddress = new EmployeeAddress();
    private static final AddressView ADDRESS_VIEW;
    private static final EmployeeView EMPLOYEE_VIEW;

    static {
        EMPLOYEE_ADDRESS_VIEW = new EmployeeAddressViewConsole();
        SCAN = new Scanner(System.in);
        EMPLOYEE_ADDRESS_REPOSITORY = new EmployeeAddressRepositorySQLImpl();
        ADDRESS_VIEW = new AddressViewConsole();
        EMPLOYEE_VIEW = new EmployeeViewConsole();
    }

    @Override
    public void saveNewData() {
        try {
            EMPLOYEE_VIEW.employeeID();
            int employeeID = SCAN.nextInt();
            ADDRESS_VIEW.addressID();
            int addressID = SCAN.nextInt();
            EMPLOYEE_ADDRESS_REPOSITORY.save(new EmployeeAddress(employeeID, addressID));
            EMPLOYEE_VIEW.displayEmployeeByID(employeeID);
            ADDRESS_VIEW.displayAddressByID(addressID);
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
            EMPLOYEE_ADDRESS_VIEW.displayEmployeeAddressByID(id);
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
            EMPLOYEE_ADDRESS_VIEW.displayEmployeeAddressByID(id);
            EMPLOYEE_ADDRESS_VIEW.employeeAddress();
            int addressID = SCAN.nextInt();
            employeeAddress.setAddressID(addressID);
            employeeAddress.setEmployeeID(id);
            EMPLOYEE_ADDRESS_REPOSITORY.update(employeeAddress);
            EMPLOYEE_ADDRESS_VIEW.changedAddressID();
            EMPLOYEE_VIEW.displayEmployeeByID(id);
            EMPLOYEE_ADDRESS_VIEW.displayEmployeeAddressByID(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteData() {
        try {
            EMPLOYEE_VIEW.employeeID();
            int id = SCAN.nextInt();
            EMPLOYEE_ADDRESS_REPOSITORY.delete(id);
            EMPLOYEE_ADDRESS_VIEW.deleteEmployeeAddressData();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void displayAll() {
        try {
            EMPLOYEE_ADDRESS_VIEW.displayAllEmployeesAddress();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
