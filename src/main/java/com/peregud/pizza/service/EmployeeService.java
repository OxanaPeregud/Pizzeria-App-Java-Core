package com.peregud.pizza.service;

import com.peregud.pizza.model.Employee;
import com.peregud.pizza.util.CheckScannerInputUtil;
import com.peregud.pizza.view.EmployeeView;
import com.peregud.pizza.view.EmployeeViewConsole;

import java.util.List;
import java.util.Scanner;

public class EmployeeService {
    public int employeeID;
    private static final Scanner SCAN;
    private static final EmployeeView EMPLOYEE_VIEW;
    private final Employee employee = new Employee();

    static {
        SCAN = new Scanner(System.in);
        EMPLOYEE_VIEW = new EmployeeViewConsole();
    }

    public EmployeeService(String firstName, String lastName, double salary) {
        employee.firstName = firstName;
        employee.lastName = lastName;
        employee.salary = salary;
    }

    public EmployeeService() {
    }

    public void salaryChange(double amount) {
        employee.salary = getSalary();
        employee.salary += amount;
        EMPLOYEE_VIEW.employeeSalaryChange();
    }

    public void quitEmployee(List<EmployeeService> employeeList) {
        EMPLOYEE_VIEW.quitEmployee();
        employeeID = CheckScannerInputUtil.checkInt();
        if (employeeID > employeeList.size())
            EMPLOYEE_VIEW.notValidID();
        else
            employeeID -= 1;
        double amount = -employeeList.get(employeeID).getSalary();
        employeeList.get(employeeID).salaryChange(amount);
    }

    public void getInfo(List<EmployeeService> employeeList) {
        EMPLOYEE_VIEW.employeeInfo();
        EMPLOYEE_VIEW.employeeDisplay(employeeList);
    }

    public void createNewEmployee(List<EmployeeService> employeeList) {
        EMPLOYEE_VIEW.employeeQuantity();
        employeeID = CheckScannerInputUtil.checkInt();
        for (int i = 0; i < employeeID; i++) {
            EMPLOYEE_VIEW.employeeFirstName();
            employee.firstName = SCAN.next();
            EMPLOYEE_VIEW.employeeLastName();
            employee.lastName = SCAN.next();
            EMPLOYEE_VIEW.employeeSalary();
            employee.salary = CheckScannerInputUtil.checkDouble();
            employeeList.add(new EmployeeService(employee.firstName, employee.lastName, employee.salary));
        }
    }

    public double getSalary() {
        return employee.salary;
    }

    public String toString() {
        return employee.toString();
    }
}
