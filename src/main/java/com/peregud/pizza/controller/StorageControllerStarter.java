package com.peregud.pizza.controller;

import com.peregud.pizza.view.StorageViewConsole;

public class StorageControllerStarter {
    public static void main(String[] args) {
        StorageViewConsole storageUtilityViewConsole = new StorageViewConsole();
        storageUtilityViewConsole.displayStorage();
        storageUtilityViewConsole.showLackOfIngredients();
    }
}