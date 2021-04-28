package com.peregud.pizza.model;

public class EmployeeAddress {
    private int employeeID;
    private int addressID;

    public EmployeeAddress() {
    }

    public EmployeeAddress(int employeeID, int addressID) {
        this.employeeID = employeeID;
        this.addressID = addressID;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public int getAddressID() {
        return addressID;
    }

    public void setAddressID(int addressID) {
        this.addressID = addressID;
    }

    @Override
    public String toString() {
        return "Employee ID: " + employeeID +
                ", Address ID: " + addressID;
    }
}
