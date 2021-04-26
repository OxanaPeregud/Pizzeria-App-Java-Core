package com.peregud.pizza.view;

import com.peregud.pizza.service.EmployeeService;

import java.util.List;

public class EmployeeViewConsole implements EmployeeView {

    @Override
    public void employeeSalaryChange() {
        System.out.println("Employee salary has been changed. Press 3 to see Employee List");
    }

    @Override
    public void quitEmployee() {
        System.out.println("Enter Employee ID whose salary you want to set to $00.00:");
    }

    @Override
    public void notValidID() {
        System.out.println("Not a Valid Employee ID! Press 3 to see Employee List");
    }

    @Override
    public void employeeInfo() {
        System.out.println("All the employee information is:");
    }

    @Override
    public void employeeDisplay(List<EmployeeService> employeeList) {
        int i = 0;
        for (EmployeeService employee : employeeList) {
            System.out.println("ID#" + (i + 1) + ": " + employee);
            i++;
        }
    }

    @Override
    public void employeeQuantity() {
        System.out.println("How many Employees would you like to create?");
    }

    @Override
    public void employeeFirstName() {
        System.out.println("Enter Employee First Name:");
    }

    @Override
    public void employeeLastName() {
        System.out.println("Enter Employee Last Name:");
    }

    @Override
    public void employeeSalary() {
        System.out.println("Enter Employee salary:");
    }

    @Override
    public void operationsMenu() {
        System.out.println("1. Create New Employee");
        System.out.println("2. Change Employee Salary");
        System.out.println("3. Display All Information About Employees");
        System.out.println("4. Set Employee Salary to $00.00");
        System.out.println("5. Show Menu Options");
        System.out.println("6. Exit employee display");
    }

    @Override
    public void selectOption() {
        System.out.println("Select menu option:");
    }

    @Override
    public void idForChangingSalary() {
        System.out.println("Enter Employee ID whose salary you want to change:");
    }

    @Override
    public void changeSalary() {
        System.out.println("Enter amount to adjust Employee salary: " +
                "ex. (-100) to decrease and (100) to increase:");
    }

    @Override
    public void showMenu() {
        System.out.println("Press 5 to see Menu Options");
    }
}
