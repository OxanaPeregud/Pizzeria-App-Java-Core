package com.peregud.pizza.view;

public class StarterViewConsole implements StarterView {

    @Override
    public void displayOperations() {
        System.out.println("Choose operation:");
        System.out.println("1. Start 'Pizza Order'");
        System.out.println("2. Start 'Create Pizza'");
        System.out.println("3. Start 'Order Statistics'");
        System.out.println("4. Start 'Storage Utility'");
        System.out.println("5. Start 'Suppliers' Delivery'");
        System.out.println("6. Start 'Employee Service'");
        System.out.println("7. Exit program");
    }

    @Override
    public void chooseOtherOperations() {
        System.out.println("\nDo you want to choose another operation? (Type y or n)");
    }

    @Override
    public void noSuchOperation() {
        System.out.println("No operation under entered number. Check Operation List");
    }

    @Override
    public void invalidInput() {
        System.out.println("Your input is invalid. You must enter a digit");
    }

    @Override
    public void exitProgram() {
        System.out.println("Program Terminated!");
    }
}
