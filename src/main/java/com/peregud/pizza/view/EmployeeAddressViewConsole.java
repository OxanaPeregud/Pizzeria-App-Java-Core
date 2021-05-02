package com.peregud.pizza.view;

import com.peregud.pizza.repository.AddressRepository;
import com.peregud.pizza.repository.AddressRepositorySQLImpl;
import com.peregud.pizza.repository.EmployeeAddressRepository;
import com.peregud.pizza.repository.EmployeeAddressRepositorySQLImpl;

import java.sql.SQLException;

public class EmployeeAddressViewConsole implements EmployeeAddressView {
    private static final EmployeeAddressRepository EMPLOYEE_ADDRESS_REPOSITORY =
            new EmployeeAddressRepositorySQLImpl();
    private static final AddressRepository ADDRESS = new AddressRepositorySQLImpl();

    @Override
    public void employeeAddress() {
        System.out.println("Enter new address ID for employee:");
    }

    @Override
    public void changedAddressID() {
        System.out.println("Employee address ID has been changed");
    }

    @Override
    public void deleteEmployeeAddressData() {
        System.out.println("Employee address data has been deleted");
    }

    @Override
    public void displayAllEmployeesAddress() throws SQLException {
        EMPLOYEE_ADDRESS_REPOSITORY.getAll().forEach(System.out::println);
    }

    @Override
    public void displayChoice() {
        System.out.println("Choose option:");
        System.out.println("1. Add new link between Employee and Address");
        System.out.println("2. Display Employee and Address by ID");
        System.out.println("3. Change Employee Address ID");
        System.out.println("4. Delete Employee Address");
        System.out.println("5. Display all Employees addresses ID");
        System.out.println("6. Exit employee address app");
    }

    @Override
    public void choiceException() {
        System.out.println("You need to enter a number from 1 to 6");
    }

    @Override
    public void displayEmployeeAddressByID(int id) throws SQLException {
        if (EMPLOYEE_ADDRESS_REPOSITORY.get(id) != null) {
            System.out.println(ADDRESS.get(EMPLOYEE_ADDRESS_REPOSITORY.get(id).getAddressID()));
        } else {
            System.out.println("There is no employee address under entered ID");
        }
    }
}
