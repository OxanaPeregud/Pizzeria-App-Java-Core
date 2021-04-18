package com.peregud.pizza.service;

import java.util.List;

public interface SoldPizzasCounterService {

    List<String> countPizzasFourCheese();

    List<String> countPizzasMargherita();

    List<String> countPizzasMeatDelight();

    List<String> countPizzasPepperoni();

    List<String> countPizzasVegetarian();

}
