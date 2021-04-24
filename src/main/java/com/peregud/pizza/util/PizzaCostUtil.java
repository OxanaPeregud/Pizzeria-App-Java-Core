package com.peregud.pizza.util;

import com.peregud.pizza.model.Ingredient;
import com.peregud.pizza.model.Pizza;

public final class PizzaCostUtil {

    private PizzaCostUtil() {
    }

    public static double fullIngredientCost(Ingredient ingredient, Pizza pizza) {
        return ingredient.getCostPerUnit() * pizza.getIngredientQuantity(ingredient);
    }

    public static double costFourCheese() {
        return fullIngredientCost(Ingredient.TRADITIONAL_DOUGH, Pizza.FOUR_CHEESE) +
                fullIngredientCost(Ingredient.SAUCE, Pizza.FOUR_CHEESE) +
                fullIngredientCost(Ingredient.CHEESE, Pizza.FOUR_CHEESE) +
                fullIngredientCost(Ingredient.OREGANO, Pizza.FOUR_CHEESE);
    }

    public static double costMargherita() {
        return fullIngredientCost(Ingredient.TRADITIONAL_DOUGH, Pizza.MARGHERITA) +
                fullIngredientCost(Ingredient.SAUCE, Pizza.MARGHERITA) +
                fullIngredientCost(Ingredient.CHEESE, Pizza.MARGHERITA) +
                fullIngredientCost(Ingredient.TOMATOES, Pizza.MARGHERITA) +
                fullIngredientCost(Ingredient.OREGANO, Pizza.MARGHERITA);
    }

    public static double costMeatDelight() {
        return fullIngredientCost(Ingredient.TRADITIONAL_DOUGH, Pizza.MEAT_DELIGHT) +
                fullIngredientCost(Ingredient.SAUCE, Pizza.MEAT_DELIGHT) +
                fullIngredientCost(Ingredient.CHEESE, Pizza.MEAT_DELIGHT) +
                fullIngredientCost(Ingredient.MEAT, Pizza.MEAT_DELIGHT) +
                fullIngredientCost(Ingredient.SAUSAGES, Pizza.MEAT_DELIGHT);
    }

    public static double costPepperoni() {
        return fullIngredientCost(Ingredient.TRADITIONAL_DOUGH, Pizza.PEPPERONI) +
                fullIngredientCost(Ingredient.SAUCE, Pizza.PEPPERONI) +
                fullIngredientCost(Ingredient.CHEESE, Pizza.PEPPERONI) +
                fullIngredientCost(Ingredient.MEAT, Pizza.PEPPERONI);
    }

    public static double costVegetarian() {
        return fullIngredientCost(Ingredient.TRADITIONAL_DOUGH, Pizza.VEGETARIAN) +
                fullIngredientCost(Ingredient.SAUCE, Pizza.VEGETARIAN) +
                fullIngredientCost(Ingredient.CHEESE, Pizza.VEGETARIAN) +
                fullIngredientCost(Ingredient.TOMATOES, Pizza.VEGETARIAN) +
                fullIngredientCost(Ingredient.PEPPER, Pizza.VEGETARIAN) +
                fullIngredientCost(Ingredient.OLIVES, Pizza.VEGETARIAN);
    }
}
