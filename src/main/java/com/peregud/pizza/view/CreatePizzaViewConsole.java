package com.peregud.pizza.view;

import com.peregud.pizza.exceptions.DoughException;
import com.peregud.pizza.exceptions.IngredientNumberException;
import com.peregud.pizza.model.Ingredient;
import com.peregud.pizza.util.DateFormatUtil;
import com.peregud.pizza.util.IngredientPriceUtil;
import com.peregud.pizza.util.RoundUtil;

import java.time.LocalDateTime;

public class CreatePizzaViewConsole implements CreatePizzaView {
    private static final DoughException DOUGH_EXCEPTION;
    private static final IngredientNumberException INGREDIENT_NUMBER_EXCEPTION;

    static {
        DOUGH_EXCEPTION = new DoughException();
        INGREDIENT_NUMBER_EXCEPTION = new IngredientNumberException();
    }

    @Override
    public void greeting() {
        System.out.println("\nWELCOME TO PIZZERIA!");
    }

    @Override
    public void menuDough() {
        System.out.println("Choose type of dough you would like to have:");
        System.out.println("1. Thin Dough\tPrice: " + RoundUtil.up(IngredientPriceUtil.priceThinDoughIncludingVAT()) + "$");
        System.out.println("2. Traditional Dough\tPrice: " + RoundUtil.up(IngredientPriceUtil.priceTraditionalDoughIncludingVAT()) + "$");
    }

    @Override
    public void menuIngredients() {
        System.out.println("Choose ingredients you would like to have in your pizza:");
        System.out.println("1. Cheese\tPrice: " + RoundUtil.up(IngredientPriceUtil.priceCheeseIncludingVAT()) + "$");
        System.out.println("2. Meat\tPrice: " + RoundUtil.up(IngredientPriceUtil.priceMeatIncludingVAT()) + "$");
        System.out.println("3. Sausages\tPrice: " + RoundUtil.up(IngredientPriceUtil.priceSausagesIncludingVAT()) + "$");
        System.out.println("4. Olives\tPrice: " + RoundUtil.up(IngredientPriceUtil.priceOlivesIncludingVAT()) + "$");
        System.out.println("5. Tomatoes\tPrice: " + RoundUtil.up(IngredientPriceUtil.priceTomatoesIncludingVAT()) + "$");
        System.out.println("6. Pepper\tPrice: " + RoundUtil.up(IngredientPriceUtil.pricePepperIncludingVAT()) + "$");
        System.out.println("7. Oregano\tPrice: " + RoundUtil.up(IngredientPriceUtil.priceOreganoIncludingVAT()) + "$");
        System.out.println("8. Sauce\tPrice: " + RoundUtil.up(IngredientPriceUtil.priceSauceIncludingVAT()) + "$");
        System.out.println("9. Cheese crust\tPrice: " + RoundUtil.up(IngredientPriceUtil.priceCrustIncludingVAT()) + "$");
    }

    @Override
    public String orderThinDough() {
        return DateFormatUtil.localDatePattern(LocalDateTime.now()) + "\t" + Ingredient.THIN_DOUGH +
                "\t" + RoundUtil.up(IngredientPriceUtil.priceThinDoughIncludingVAT()) + "$";
    }

    @Override
    public String orderTraditionalDough() {
        return DateFormatUtil.localDatePattern(LocalDateTime.now()) + "\t" + Ingredient.TRADITIONAL_DOUGH +
                "\t" + RoundUtil.up(IngredientPriceUtil.priceTraditionalDoughIncludingVAT()) + "$";
    }

    @Override
    public String orderCheese() {
        return DateFormatUtil.localDatePattern(LocalDateTime.now()) + "\t" + Ingredient.CHEESE +
                "\t" + RoundUtil.up(IngredientPriceUtil.priceCheeseIncludingVAT()) + "$";
    }

    @Override
    public String orderMeat() {
        return DateFormatUtil.localDatePattern(LocalDateTime.now()) + "\t" + Ingredient.MEAT +
                "\t" + RoundUtil.up(IngredientPriceUtil.priceMeatIncludingVAT()) + "$";
    }

    @Override
    public String orderSausages() {
        return DateFormatUtil.localDatePattern(LocalDateTime.now()) + "\t" + Ingredient.SAUSAGES +
                "\t" + RoundUtil.up(IngredientPriceUtil.priceSausagesIncludingVAT()) + "$";
    }

    @Override
    public String orderOlives() {
        return DateFormatUtil.localDatePattern(LocalDateTime.now()) + "\t" + Ingredient.OLIVES +
                "\t" + RoundUtil.up(IngredientPriceUtil.priceOlivesIncludingVAT()) + "$";
    }

    @Override
    public String orderTomatoes() {
        return DateFormatUtil.localDatePattern(LocalDateTime.now()) + "\t" + Ingredient.TOMATOES +
                "\t" + RoundUtil.up(IngredientPriceUtil.priceTomatoesIncludingVAT()) + "$";
    }

    @Override
    public String orderPepper() {
        return DateFormatUtil.localDatePattern(LocalDateTime.now()) + "\t" + Ingredient.PEPPER +
                "\t" + RoundUtil.up(IngredientPriceUtil.pricePepperIncludingVAT()) + "$";
    }

    @Override
    public String orderOregano() {
        return DateFormatUtil.localDatePattern(LocalDateTime.now()) + "\t" + Ingredient.OREGANO +
                "\t" + RoundUtil.up(IngredientPriceUtil.priceOreganoIncludingVAT()) + "$";
    }

    @Override
    public String orderSauce() {
        return DateFormatUtil.localDatePattern(LocalDateTime.now()) + "\t" + Ingredient.SAUCE +
                "\t" + RoundUtil.up(IngredientPriceUtil.priceSauceIncludingVAT()) + "$";
    }

    @Override
    public String orderCrust() {
        return DateFormatUtil.localDatePattern(LocalDateTime.now()) + "\t" + Ingredient.CRUST +
                "\t" + RoundUtil.up(IngredientPriceUtil.priceCrustIncludingVAT()) + "$";
    }

    @Override
    public void displayInfoThinDough() {
        System.out.println("Ingredient " + Ingredient.THIN_DOUGH);
        System.out.println("Calories: " + Ingredient.THIN_DOUGH.getCalories());
        System.out.println("Price: " + RoundUtil.up(IngredientPriceUtil.priceThinDoughIncludingVAT()) + "$");
        System.out.println();
    }

    @Override
    public void displayInfoTraditionalDough() {
        System.out.println("Ingredient " + Ingredient.TRADITIONAL_DOUGH);
        System.out.println("Calories: " + Ingredient.TRADITIONAL_DOUGH.getCalories());
        System.out.println("Price: " + RoundUtil.up(IngredientPriceUtil.priceTraditionalDoughIncludingVAT()) + "$");
        System.out.println();
    }

    @Override
    public void displayInfoCheese() {
        System.out.println("Ingredient " + Ingredient.CHEESE);
        System.out.println("Calories: " + Ingredient.CHEESE.getCalories());
        System.out.println("Price: " + RoundUtil.up(IngredientPriceUtil.priceCheeseIncludingVAT()) + "$");
        System.out.println();
    }

    @Override
    public void displayInfoMeat() {
        System.out.println("Ingredient " + Ingredient.MEAT);
        System.out.println("Calories: " + Ingredient.MEAT.getCalories());
        System.out.println("Price: " + RoundUtil.up(IngredientPriceUtil.priceMeatIncludingVAT()) + "$");
        System.out.println();
    }

    @Override
    public void displayInfoSausages() {
        System.out.println("Ingredient " + Ingredient.SAUSAGES);
        System.out.println("Calories: " + Ingredient.SAUSAGES.getCalories());
        System.out.println("Price: " + RoundUtil.up(IngredientPriceUtil.priceSausagesIncludingVAT()) + "$");
        System.out.println();
    }

    @Override
    public void displayInfoOlives() {
        System.out.println("Ingredient " + Ingredient.OLIVES);
        System.out.println("Calories: " + Ingredient.OLIVES.getCalories());
        System.out.println("Price: " + RoundUtil.up(IngredientPriceUtil.priceOlivesIncludingVAT()) + "$");
        System.out.println();
    }

    @Override
    public void displayInfoTomatoes() {
        System.out.println("Ingredient " + Ingredient.TOMATOES);
        System.out.println("Calories: " + Ingredient.TOMATOES.getCalories());
        System.out.println("Price: " + RoundUtil.up(IngredientPriceUtil.priceTomatoesIncludingVAT()) + "$");
        System.out.println();
    }

    @Override
    public void displayInfoPepper() {
        System.out.println("Ingredient " + Ingredient.PEPPER);
        System.out.println("Calories: " + Ingredient.PEPPER.getCalories());
        System.out.println("Price: " + RoundUtil.up(IngredientPriceUtil.pricePepperIncludingVAT()) + "$");
        System.out.println();
    }

    @Override
    public void displayInfoOregano() {
        System.out.println("Ingredient " + Ingredient.OREGANO);
        System.out.println("Calories: " + Ingredient.OREGANO.getCalories());
        System.out.println("Price: " + RoundUtil.up(IngredientPriceUtil.priceOreganoIncludingVAT()) + "$");
        System.out.println();
    }

    @Override
    public void displayInfoSauce() {
        System.out.println("Ingredient " + Ingredient.SAUCE);
        System.out.println("Calories: " + Ingredient.SAUCE.getCalories());
        System.out.println("Price: " + RoundUtil.up(IngredientPriceUtil.priceSauceIncludingVAT()) + "$");
        System.out.println();
    }

    @Override
    public void displayInfoCrust() {
        System.out.println("Ingredient " + Ingredient.CRUST);
        System.out.println("Calories: " + Ingredient.CRUST.getCalories());
        System.out.println("Price: " + RoundUtil.up(IngredientPriceUtil.priceCrustIncludingVAT()) + "$");
        System.out.println();
    }

    @Override
    public void displayInfoIngredients() {
        displayInfoThinDough();
        displayInfoTraditionalDough();
        displayInfoCheese();
        displayInfoMeat();
        displayInfoSausages();
        displayInfoOlives();
        displayInfoTomatoes();
        displayInfoPepper();
        displayInfoOregano();
        displayInfoSauce();
        displayInfoCrust();
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
        System.out.println(DOUGH_EXCEPTION.toString());
    }

    @Override
    public void ingredientNumberException() {
        System.out.println(INGREDIENT_NUMBER_EXCEPTION.toString());
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
