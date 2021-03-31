package com.peregud.pizza.controller;

import com.peregud.pizza.view.StorageUtilityViewConsole;

public class StorageUtilityControllerStarter {
    public static void main(String[] args) {
        StorageUtilityViewConsole storageUtilityViewConsole = new StorageUtilityViewConsole();
        storageUtilityViewConsole.displayStorage();
        storageUtilityViewConsole.showLackOfIngredients();
    }
}