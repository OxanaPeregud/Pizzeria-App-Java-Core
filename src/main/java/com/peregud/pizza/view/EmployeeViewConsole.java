package com.peregud.pizza.view;

import com.peregud.pizza.repository.EmployeeRepository;
import com.peregud.pizza.repository.EmployeeRepositorySQLImpl;

import java.sql.SQLException;

public class EmployeeViewConsole implements EmployeeView {
    private static final EmployeeRepository EMPLOYEE_REPOSITORY;

    static {
        EMPLOYEE_REPOSITORY = new EmployeeRepositorySQLImpl();
    }

    public void employeeFirstName() {
        System.out.println("Enter employee First Name:");
    }

    public void employeeLastName() {
        System.out.println("Enter employee Last Name:");
    }

    public void employeeSalary() {
        System.out.println("Enter employee salary:");
    }

    public void employeeID() {
        System.out.println("Enter employee ID:");
    }

    public void displayEmployeeByID(int id) throws SQLException {
        if (EMPLOYEE_REPOSITORY.get(id) != null) {
            System.out.println(EMPLOYEE_REPOSITORY.get(id));
        } else {
            System.out.println("There is no employee under entered ID");
        }
    }

    public void setNewSalary() {
        System.out.println("Enter new salary:");
    }

    public void changedSalary() {
        System.out.println("Employee salary has been changed");
    }

    public void deleteEmployee() {
        System.out.println("Employee has been deleted");
    }

    public void displayAllEmployees() throws SQLException {
        EMPLOYEE_REPOSITORY.getAll().forEach(System.out::println);
    }

    public void displayChoice() {
        System.out.println("Choose option:");
        System.out.println("1. Add new Employee");
        System.out.println("2. Display Employee by ID");
        System.out.println("3. Change Employee Salary");
        System.out.println("4. Delete Employee");
        System.out.println("5. Display all Employees");
        System.out.println("6. Exit employee app");
    }

    public void choiceException() {
        System.out.println("You need to enter a number from 1 to 6");
    }
}
