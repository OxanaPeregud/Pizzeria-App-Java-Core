package com.peregud.pizza.controller;

import com.peregud.pizza.service.SupplyService;

public class SupplierDeliveringControllerStarter {
    public static void main(String[] args) {
        SupplyService supplyService = new SupplyService();
        supplyService.start();
    }
}
