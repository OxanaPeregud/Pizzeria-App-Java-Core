package com.peregud.pizza.util;

import com.peregud.pizza.model.Ingredient;
import com.peregud.pizza.model.Pizza;
import com.peregud.pizza.repository.StorageRepository;

public final class CookUtil {
    private static final StorageRepository STORAGE;

    static {
        STORAGE = new StorageRepository();
    }

    private CookUtil() {
    }

    public static void pizzaFourCheese() {
        STORAGE.changeIngredientQuantity(Pizza.FOUR_CHEESE);
    }

    public static void pizzaMargherita() {
        STORAGE.changeIngredientQuantity(Pizza.MARGHERITA);
    }

    public static void pizzaMeatDelight() {
        STORAGE.changeIngredientQuantity(Pizza.MEAT_DELIGHT);
    }

    public static void pizzaPepperoni() {
        STORAGE.changeIngredientQuantity(Pizza.PEPPERONI);
    }

    public static void pizzaVegetarian() {
        STORAGE.changeIngredientQuantity(Pizza.VEGETARIAN);
    }

    public static void thinDough() {
        STORAGE.removeOneIngredient(Ingredient.THIN_DOUGH);
    }

    public static void traditionalDough() {
        STORAGE.removeOneIngredient(Ingredient.TRADITIONAL_DOUGH);
    }

    public static void cheese() {
        STORAGE.removeOneIngredient(Ingredient.CHEESE);
    }

    public static void meat() {
        STORAGE.removeOneIngredient(Ingredient.MEAT);
    }

    public static void sausages() {
        STORAGE.removeOneIngredient(Ingredient.SAUSAGES);
    }

    public static void olives() {
        STORAGE.removeOneIngredient(Ingredient.OLIVES);
    }

    public static void tomatoes() {
        STORAGE.removeOneIngredient(Ingredient.TOMATOES);
    }

    public static void pepper() {
        STORAGE.removeOneIngredient(Ingredient.PEPPER);
    }

    public static void oregano() {
        STORAGE.removeOneIngredient(Ingredient.OREGANO);
    }

    public static void sauce() {
        STORAGE.removeOneIngredient(Ingredient.SAUCE);
    }
}
