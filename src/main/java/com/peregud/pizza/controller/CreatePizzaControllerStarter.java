package com.peregud.pizza.controller;

import com.peregud.pizza.service.CreatePizzaService;

public class CreatePizzaControllerStarter {
    public static void main(String[] args) {
        CreatePizzaService createPizzaService = new CreatePizzaService();
        createPizzaService.start();
        createPizzaService.chooseDough();
        createPizzaService.chooseIngredients();
        createPizzaService.addIngredientsQuestion();
    }
}