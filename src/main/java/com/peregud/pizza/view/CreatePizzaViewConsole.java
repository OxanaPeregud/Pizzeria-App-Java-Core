package com.peregud.pizza.view;

import com.peregud.pizza.model.Ingredient;
import com.peregud.pizza.util.DateFormatUtil;
import com.peregud.pizza.util.IngredientPriceUtil;
import com.peregud.pizza.util.RoundUtil;

import java.time.LocalDateTime;

public class CreatePizzaViewConsole implements CreatePizzaView {

    @Override
    public void greeting() {
        System.out.println("\nWELCOME TO PIZZERIA!");
    }

    @Override
    public void menuDough() {
        System.out.println("Choose type of dough you would like to have:");
        System.out.println("1. Thin Dough\tPrice: " + RoundUtil.up(
                IngredientPriceUtil.priceIncludingVAT(Ingredient.THIN_DOUGH)) + "$");
        System.out.println("2. Traditional Dough\tPrice: " + RoundUtil.up(
                IngredientPriceUtil.priceIncludingVAT(Ingredient.TRADITIONAL_DOUGH)) + "$");
    }

    @Override
    public void menuIngredients() {
        System.out.println("Choose ingredients you would like to have in your pizza:");
        System.out.println("1. Cheese\tPrice: " + RoundUtil.up(
                IngredientPriceUtil.priceIncludingVAT(Ingredient.CHEESE)) + "$");
        System.out.println("2. Meat\tPrice: " + RoundUtil.up(
                IngredientPriceUtil.priceIncludingVAT(Ingredient.MEAT)) + "$");
        System.out.println("3. Sausages\tPrice: " + RoundUtil.up(
                IngredientPriceUtil.priceIncludingVAT(Ingredient.SAUSAGES)) + "$");
        System.out.println("4. Olives\tPrice: " + RoundUtil.up(
                IngredientPriceUtil.priceIncludingVAT(Ingredient.OLIVES)) + "$");
        System.out.println("5. Tomatoes\tPrice: " + RoundUtil.up(
                IngredientPriceUtil.priceIncludingVAT(Ingredient.TOMATOES)) + "$");
        System.out.println("6. Pepper\tPrice: " + RoundUtil.up(
                IngredientPriceUtil.priceIncludingVAT(Ingredient.PEPPER)) + "$");
        System.out.println("7. Oregano\tPrice: " + RoundUtil.up(
                IngredientPriceUtil.priceIncludingVAT(Ingredient.OREGANO)) + "$");
        System.out.println("8. Sauce\tPrice: " + RoundUtil.up(
                IngredientPriceUtil.priceIncludingVAT(Ingredient.SAUCE)) + "$");
    }

    @Override
    public String orderIngredient(Ingredient ingredient) {
        return DateFormatUtil.localDatePattern(LocalDateTime.now()) + "\t" + ingredient +
                "\t" + RoundUtil.up(IngredientPriceUtil.priceIncludingVAT(ingredient)) + "$";
    }

    @Override
    public void displayInfoAboutIngredient(Ingredient ingredient) {
        System.out.println("Ingredient " + ingredient);
        System.out.println("Calories: " + ingredient.getCalories());
        System.out.println("Price: " + RoundUtil.up(IngredientPriceUtil.priceIncludingVAT(ingredient)) + "$");
        System.out.println();
    }

    @Override
    public void totalCalories(int totalCalories) {
        System.out.println("Total Calories of Created Pizza: " + totalCalories);
    }

    @Override
    public void totalOrder(double totalOrder) {
        System.out.println("Total order is " + totalOrder + "$");
    }

    @Override
    public void addDoughQuestion() {
        System.out.println("\nDo you want to add dough? (Type y or n)");
    }

    @Override
    public void addIngredientsQuestion() {
        System.out.println("\nDo you want to add more ingredients? (Type y or n)");
    }

    @Override
    public void doughException() {
        System.out.println("To choose dough you need to enter 1 or 2");
    }

    @Override
    public void ingredientNumberException() {
        System.out.println("We don't have an ingredient under entered number");
    }

    @Override
    public void displayOptions() {
        System.out.println("Choose what would you like to do:");
        System.out.println("1. Create your own pizza");
        System.out.println("2. Display info about ingredients that we have");
        System.out.println("3. Order pizza from our menu");
        System.out.println("4. Exit");
    }

    @Override
    public void choiceView() {
        System.out.println("You need to enter a number from 1 to 4");
    }
}
