package com.peregud.pizza.service;

import com.peregud.pizza.model.Ingredient;
import com.peregud.pizza.model.Pizza;
import com.peregud.pizza.repository.StorageRepository;

public class CookService {
    private static final StorageRepository STORAGE;

    static {
        STORAGE = new StorageRepository();
    }

    public void pizzaFourCheese() {
        STORAGE.changeIngredientQuantity(Pizza.FOUR_CHEESE);
    }

    public void pizzaMargherita() {
        STORAGE.changeIngredientQuantity(Pizza.MARGHERITA);
    }

    public void pizzaMeatDelight() {
        STORAGE.changeIngredientQuantity(Pizza.MEAT_DELIGHT);
    }

    public void pizzaPepperoni() {
        STORAGE.changeIngredientQuantity(Pizza.PEPPERONI);
    }

    public void pizzaVegetarian() {
        STORAGE.changeIngredientQuantity(Pizza.VEGETARIAN);
    }

    public void thinDough() {
        STORAGE.removeOneIngredient(Ingredient.THIN_DOUGH);
    }

    public void traditionalDough() {
        STORAGE.removeOneIngredient(Ingredient.TRADITIONAL_DOUGH);
    }

    public void cheese() {
        STORAGE.removeOneIngredient(Ingredient.CHEESE);
    }

    public void meat() {
        STORAGE.removeOneIngredient(Ingredient.MEAT);
    }

    public void sausages() {
        STORAGE.removeOneIngredient(Ingredient.SAUSAGES);
    }

    public void olives() {
        STORAGE.removeOneIngredient(Ingredient.OLIVES);
    }

    public void tomatoes() {
        STORAGE.removeOneIngredient(Ingredient.TOMATOES);
    }

    public void pepper() {
        STORAGE.removeOneIngredient(Ingredient.PEPPER);
    }

    public void oregano() {
        STORAGE.removeOneIngredient(Ingredient.OREGANO);
    }

    public void sauce() {
        STORAGE.removeOneIngredient(Ingredient.SAUCE);
    }
}
