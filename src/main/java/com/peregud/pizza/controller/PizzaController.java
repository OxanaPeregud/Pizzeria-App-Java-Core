/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.controller;

import com.peregud.pizza.service.CreatePizzaService;
import com.peregud.pizza.service.PizzaOrderService;
import com.peregud.pizza.service.SupplyService;
import com.peregud.pizza.util.CheckScannerInputUtil;
import com.peregud.pizza.view.StarterView;
import com.peregud.pizza.view.StarterViewConsole;
import com.peregud.pizza.view.StorageView;
import com.peregud.pizza.view.StorageViewConsole;

import java.util.Scanner;

public class PizzaController {
    private final StarterView starterView = new StarterViewConsole();
    private final PizzaOrderService pizzaOrder = new PizzaOrderService();
    private final CreatePizzaService createPizza = new CreatePizzaService();
    private final OrderStatisticsController orderStatistics = new OrderStatisticsController();
    private final StorageView storageView = new StorageViewConsole();
    private final SupplyService supply = new SupplyService();
    private final EmployeeController employee = new EmployeeController();
    private boolean programOn = true;

    public void start() {
        while (programOn) {
            starterView.displayOperations();
            int operationChoice = CheckScannerInputUtil.checkInt();
            switch (operationChoice) {
                case 1:
                    pizzaOrder.start();
                    pizzaOrder.displayOptions();
                    addChoiceQuestion();
                    break;
                case 2:
                    createPizza.start();
                    createPizza.displayOptions();
                    createPizza.chooseIngredients();
                    createPizza.addIngredientsQuestion();
                    break;
                case 3:
                    orderStatistics.start();
                    break;
                case 4:
                    storageView.displayStorage();
                    storageView.showLackOfIngredients();
                    addChoiceQuestion();
                    break;
                case 5:
                    supply.start();
                    addChoiceQuestion();
                    break;
                case 6:
                    employee.chooseOperation();
                    break;
                case 7:
                    starterView.exitProgram();
                    programOn = false;
                    break;
                default:
                    starterView.noSuchOperation();
                    start();
                    break;
            }
        }
    }

    public void addChoiceQuestion() {
        try {
            starterView.chooseOtherOperations();
            Scanner scan = new Scanner(System.in);
            char ch = scan.next().charAt(0);
            if (ch == 'Y' || ch == 'y') {
                start();
            } else {
                programOn = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
