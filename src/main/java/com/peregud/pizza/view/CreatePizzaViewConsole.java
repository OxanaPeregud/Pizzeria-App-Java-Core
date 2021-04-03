package com.peregud.pizza.view;

import com.peregud.pizza.exceptions.DoughException;
import com.peregud.pizza.exceptions.IngredientNumberException;
import com.peregud.pizza.exceptions.PaymentChoiceException;
import com.peregud.pizza.model.Ingredient;
import com.peregud.pizza.util.DateFormatUtil;
import com.peregud.pizza.util.IngredientPriceUtil;
import com.peregud.pizza.util.RoundUtil;

import java.time.LocalDateTime;

public class CreatePizzaViewConsole implements CreatePizzaView {
    private static final DoughException DOUGH_EXCEPTION;
    private static final IngredientNumberException INGREDIENT_NUMBER_EXCEPTION;
    private static final PaymentChoiceException PAYMENT_CHOICE_EXCEPTION;

    static {
        DOUGH_EXCEPTION = new DoughException();
        INGREDIENT_NUMBER_EXCEPTION = new IngredientNumberException();
        PAYMENT_CHOICE_EXCEPTION = new PaymentChoiceException();
    }

    public void greeting() {
        System.out.println("\nWELCOME TO PIZZERIA!");
    }

    public void menuDough() {
        System.out.println("Choose type of dough you would like to have:");
        System.out.println("1. Thin Dough\tPrice: " + RoundUtil.up(IngredientPriceUtil.priceThinDoughIncludingVAT()) + "$");
        System.out.println("2. Traditional Dough\tPrice: " + RoundUtil.up(IngredientPriceUtil.priceTraditionalDoughIncludingVAT()) + "$");
    }

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

    public String orderThinDough() {
        return DateFormatUtil.localDatePattern(LocalDateTime.now()) + "\t" + Ingredient.THIN_DOUGH +
                "\t" + RoundUtil.up(IngredientPriceUtil.priceThinDoughIncludingVAT()) + "$";
    }

    public String orderTraditionalDough() {
        return DateFormatUtil.localDatePattern(LocalDateTime.now()) + "\t" + Ingredient.TRADITIONAL_DOUGH +
                "\t" + RoundUtil.up(IngredientPriceUtil.priceTraditionalDoughIncludingVAT()) + "$";
    }

    public String orderCheese() {
        return DateFormatUtil.localDatePattern(LocalDateTime.now()) + "\t" + Ingredient.CHEESE +
                "\t" + RoundUtil.up(IngredientPriceUtil.priceCheeseIncludingVAT()) + "$";
    }

    public String orderMeat() {
        return DateFormatUtil.localDatePattern(LocalDateTime.now()) + "\t" + Ingredient.MEAT +
                "\t" + RoundUtil.up(IngredientPriceUtil.priceMeatIncludingVAT()) + "$";
    }

    public String orderSausages() {
        return DateFormatUtil.localDatePattern(LocalDateTime.now()) + "\t" + Ingredient.SAUSAGES +
                "\t" + RoundUtil.up(IngredientPriceUtil.priceSausagesIncludingVAT()) + "$";
    }

    public String orderOlives() {
        return DateFormatUtil.localDatePattern(LocalDateTime.now()) + "\t" + Ingredient.OLIVES +
                "\t" + RoundUtil.up(IngredientPriceUtil.priceOlivesIncludingVAT()) + "$";
    }

    public String orderTomatoes() {
        return DateFormatUtil.localDatePattern(LocalDateTime.now()) + "\t" + Ingredient.TOMATOES +
                "\t" + RoundUtil.up(IngredientPriceUtil.priceTomatoesIncludingVAT()) + "$";
    }

    public String orderPepper() {
        return DateFormatUtil.localDatePattern(LocalDateTime.now()) + "\t" + Ingredient.PEPPER +
                "\t" + RoundUtil.up(IngredientPriceUtil.pricePepperIncludingVAT()) + "$";
    }

    public String orderOregano() {
        return DateFormatUtil.localDatePattern(LocalDateTime.now()) + "\t" + Ingredient.OREGANO +
                "\t" + RoundUtil.up(IngredientPriceUtil.priceOreganoIncludingVAT()) + "$";
    }

    public String orderSauce() {
        return DateFormatUtil.localDatePattern(LocalDateTime.now()) + "\t" + Ingredient.SAUCE +
                "\t" + RoundUtil.up(IngredientPriceUtil.priceSauceIncludingVAT()) + "$";
    }

    public String orderCrust() {
        return DateFormatUtil.localDatePattern(LocalDateTime.now()) + "\t" + Ingredient.CRUST +
                "\t" + RoundUtil.up(IngredientPriceUtil.priceCrustIncludingVAT()) + "$";
    }

    public void displayInfoThinDough() {
        System.out.println("Ingredient " + Ingredient.THIN_DOUGH);
        System.out.println("Calories: " + Ingredient.THIN_DOUGH.getCalories());
        System.out.println("Price: " + RoundUtil.up(IngredientPriceUtil.priceThinDoughIncludingVAT()) + "$");
        System.out.println();
    }

    public void displayInfoTraditionalDough() {
        System.out.println("Ingredient " + Ingredient.TRADITIONAL_DOUGH);
        System.out.println("Calories: " + Ingredient.TRADITIONAL_DOUGH.getCalories());
        System.out.println("Price: " + RoundUtil.up(IngredientPriceUtil.priceTraditionalDoughIncludingVAT()) + "$");
        System.out.println();
    }

    public void displayInfoCheese() {
        System.out.println("Ingredient " + Ingredient.CHEESE);
        System.out.println("Calories: " + Ingredient.CHEESE.getCalories());
        System.out.println("Price: " + RoundUtil.up(IngredientPriceUtil.priceCheeseIncludingVAT()) + "$");
        System.out.println();
    }

    public void displayInfoMeat() {
        System.out.println("Ingredient " + Ingredient.MEAT);
        System.out.println("Calories: " + Ingredient.MEAT.getCalories());
        System.out.println("Price: " + RoundUtil.up(IngredientPriceUtil.priceMeatIncludingVAT()) + "$");
        System.out.println();
    }

    public void displayInfoSausages() {
        System.out.println("Ingredient " + Ingredient.SAUSAGES);
        System.out.println("Calories: " + Ingredient.SAUSAGES.getCalories());
        System.out.println("Price: " + RoundUtil.up(IngredientPriceUtil.priceSausagesIncludingVAT()) + "$");
        System.out.println();
    }

    public void displayInfoOlives() {
        System.out.println("Ingredient " + Ingredient.OLIVES);
        System.out.println("Calories: " + Ingredient.OLIVES.getCalories());
        System.out.println("Price: " + RoundUtil.up(IngredientPriceUtil.priceOlivesIncludingVAT()) + "$");
        System.out.println();
    }

    public void displayInfoTomatoes() {
        System.out.println("Ingredient " + Ingredient.TOMATOES);
        System.out.println("Calories: " + Ingredient.TOMATOES.getCalories());
        System.out.println("Price: " + RoundUtil.up(IngredientPriceUtil.priceTomatoesIncludingVAT()) + "$");
        System.out.println();
    }

    public void displayInfoPepper() {
        System.out.println("Ingredient " + Ingredient.PEPPER);
        System.out.println("Calories: " + Ingredient.PEPPER.getCalories());
        System.out.println("Price: " + RoundUtil.up(IngredientPriceUtil.pricePepperIncludingVAT()) + "$");
        System.out.println();
    }

    public void displayInfoOregano() {
        System.out.println("Ingredient " + Ingredient.OREGANO);
        System.out.println("Calories: " + Ingredient.OREGANO.getCalories());
        System.out.println("Price: " + RoundUtil.up(IngredientPriceUtil.priceOreganoIncludingVAT()) + "$");
        System.out.println();
    }

    public void displayInfoSauce() {
        System.out.println("Ingredient " + Ingredient.SAUCE);
        System.out.println("Calories: " + Ingredient.SAUCE.getCalories());
        System.out.println("Price: " + RoundUtil.up(IngredientPriceUtil.priceSauceIncludingVAT()) + "$");
        System.out.println();
    }

    public void displayInfoCrust() {
        System.out.println("Ingredient " + Ingredient.CRUST);
        System.out.println("Calories: " + Ingredient.CRUST.getCalories());
        System.out.println("Price: " + RoundUtil.up(IngredientPriceUtil.priceCrustIncludingVAT()) + "$");
        System.out.println();
    }

    public void totalCalories(int totalCalories) {
        System.out.println("Total Calories of Created Pizza: " + totalCalories);
    }

    public void totalOrder(double totalOrder) {
        System.out.println("Total order is " + totalOrder + "$");
    }

    public void addDoughQuestion() {
        System.out.println("\nDo you want to add dough? (Type y or n)");
    }

    public void addIngredientsQuestion() {
        System.out.println("\nDo you want to add more ingredients? (Type y or n)");
    }

    public void paymentChoice() {
        System.out.println("How would you like to pay:");
        System.out.println("1. Cash");
        System.out.println("2. Credit card");
        System.out.println("3. Online");
    }

    public void doughException() {
        System.out.println(DOUGH_EXCEPTION.toString());
    }

    public void ingredientNumberException() {
        System.out.println(INGREDIENT_NUMBER_EXCEPTION.toString());
    }

    public void paymentChoiceException() {
        System.out.println(PAYMENT_CHOICE_EXCEPTION.toString());
    }

    public void displayOptions() {
        System.out.println("Choose what would you like to do:");
        System.out.println("1. Create your own pizza");
        System.out.println("2. Display info about ingredients that we have");
        System.out.println("3. Order pizza from our menu");
        System.out.println("4. Exit");
    }

    public void choiceView() {
        System.out.println("You need to enter a number from 1 to 4");
    }
}
