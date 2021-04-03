package com.peregud.pizza.controller;

import com.peregud.pizza.service.CreatePizzaService;
import com.peregud.pizza.service.PizzaOrderService;
import com.peregud.pizza.service.SupplyService;
import com.peregud.pizza.util.CheckUtil;
import com.peregud.pizza.view.StarterViewConsole;
import com.peregud.pizza.view.StorageViewConsole;

import java.io.IOException;
import java.util.Scanner;

public class PizzaController {
    private static final StarterViewConsole STARTER_VIEW;
    private static final PizzaOrderService PIZZA_ORDER;
    private static final CreatePizzaService CREATE_PIZZA;
    private static final OrderStatisticsController ORDER_STATISTICS;
    private static final StorageViewConsole STORAGE_VIEW;
    private static final SupplyService SUPPLY;
    private static final EmployeeController EMPLOYEE;
    private static boolean programOn;

    static {
        STARTER_VIEW = new StarterViewConsole();
        PIZZA_ORDER = new PizzaOrderService();
        CREATE_PIZZA = new CreatePizzaService();
        ORDER_STATISTICS = new OrderStatisticsController();
        STORAGE_VIEW = new StorageViewConsole();
        SUPPLY = new SupplyService();
        EMPLOYEE = new EmployeeController();
        programOn = true;
    }

    public PizzaController() {
    }

    public void start() throws IOException {
        while (programOn) {
            STARTER_VIEW.displayOperations();
            int operationChoice = CheckUtil.checkInt();
            switch (operationChoice) {
                case 1:
                    PIZZA_ORDER.start();
                    PIZZA_ORDER.choosePizza();
                    addChoiceQuestion();
                    break;
                case 2:
                    CREATE_PIZZA.start();
                    CREATE_PIZZA.chooseDough();
                    CREATE_PIZZA.chooseIngredients();
                    CREATE_PIZZA.addIngredientsQuestion();
                    addChoiceQuestion();
                    break;
                case 3:
                    ORDER_STATISTICS.start();
                    addChoiceQuestion();
                    break;
                case 4:
                    STORAGE_VIEW.displayStorage();
                    STORAGE_VIEW.showLackOfIngredients();
                    addChoiceQuestion();
                    break;
                case 5:
                    SUPPLY.start();
                    addChoiceQuestion();
                    break;
                case 6:
                    EMPLOYEE.start();
                    addChoiceQuestion();
                    break;
                case 7:
                    STARTER_VIEW.exitProgram();
                    programOn = false;
                    break;
                default:
                    STARTER_VIEW.noSuchOperation();
                    start();
                    break;
            }
        }
    }

    public void addChoiceQuestion() throws IOException {
        STARTER_VIEW.chooseOtherOperations();
        Scanner scan = new Scanner(System.in);
        char ch = scan.next().charAt(0);
        if (ch == 'Y' || ch == 'y') {
            start();
        }
    }
}
