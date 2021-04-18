package com.peregud.pizza.service;

import com.peregud.pizza.exceptions.DoughException;
import com.peregud.pizza.exceptions.IngredientNumberException;
import com.peregud.pizza.exceptions.PaymentChoiceException;
import com.peregud.pizza.model.Check;
import com.peregud.pizza.model.Ingredient;
import com.peregud.pizza.model.PaymentMethod;
import com.peregud.pizza.util.*;
import com.peregud.pizza.view.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CreatePizzaService {
    private static final CreatePizzaView CREATE_PIZZA_VIEW;
    private static final Map<Integer, Ingredient> DOUGH;
    private static final Map<Integer, Ingredient> INGREDIENTS;
    private static final IngredientCaloriesCalculatorService INGREDIENT_CALORIES;
    private static final CookService COOK;
    private static final OrderCalculatorService ORDER;
    private static final CashPaymentView CASH_PAYMENT_VIEW;
    private static final CheckView CHECK_VIEW;
    private static final Map<Integer, PaymentMethod> PAYMENT_METHOD;
    private static final PizzaOrderService PIZZA_ORDER;
    private char ch;
    private int choice;

    static {
        DOUGH = new HashMap<>();
        DOUGH.put(1, Ingredient.THIN_DOUGH);
        DOUGH.put(2, Ingredient.TRADITIONAL_DOUGH);

        INGREDIENTS = new HashMap<>();
        INGREDIENTS.put(1, Ingredient.CHEESE);
        INGREDIENTS.put(2, Ingredient.MEAT);
        INGREDIENTS.put(3, Ingredient.SAUSAGES);
        INGREDIENTS.put(4, Ingredient.OLIVES);
        INGREDIENTS.put(5, Ingredient.TOMATOES);
        INGREDIENTS.put(6, Ingredient.PEPPER);
        INGREDIENTS.put(7, Ingredient.OREGANO);
        INGREDIENTS.put(8, Ingredient.SAUCE);
        INGREDIENTS.put(9, Ingredient.CRUST);

        CREATE_PIZZA_VIEW = new CreatePizzaViewConsole();
        INGREDIENT_CALORIES = new IngredientCaloriesCalculatorService(new ArrayList<>());
        COOK = new CookService();
        CASH_PAYMENT_VIEW = new CashPaymentViewConsole();
        CHECK_VIEW = new CheckViewConsole();
        ORDER = new OrderCalculatorService(new ArrayList<>());
        PIZZA_ORDER = new PizzaOrderService();

        PAYMENT_METHOD = new HashMap<>();
        PAYMENT_METHOD.put(1, PaymentMethod.CASH);
        PAYMENT_METHOD.put(2, PaymentMethod.CARD);
        PAYMENT_METHOD.put(3, PaymentMethod.ONLINE);
    }

    public void start() {
        CREATE_PIZZA_VIEW.greeting();
    }

    public void displayOptions() {
        CREATE_PIZZA_VIEW.displayOptions();
        int choice = CheckUtil.checkInt();
        switch (choice) {
            case 1:
                chooseDough();
                break;
            case 2:
                CREATE_PIZZA_VIEW.displayInfoThinDough();
                CREATE_PIZZA_VIEW.displayInfoTraditionalDough();
                CREATE_PIZZA_VIEW.displayInfoCheese();
                CREATE_PIZZA_VIEW.displayInfoMeat();
                CREATE_PIZZA_VIEW.displayInfoSausages();
                CREATE_PIZZA_VIEW.displayInfoOlives();
                CREATE_PIZZA_VIEW.displayInfoTomatoes();
                CREATE_PIZZA_VIEW.displayInfoPepper();
                CREATE_PIZZA_VIEW.displayInfoOregano();
                CREATE_PIZZA_VIEW.displayInfoSauce();
                CREATE_PIZZA_VIEW.displayInfoCrust();
                displayOptions();
                break;
            case 3:
                PIZZA_ORDER.start();
                PIZZA_ORDER.displayOptions();
                break;
            case 4:
                break;
            default:
                CREATE_PIZZA_VIEW.choiceView();
                displayOptions();
                break;
        }
    }

    public void chooseDough() {
        CREATE_PIZZA_VIEW.menuDough();
        try {
            choice = CheckUtil.checkInt();
            switch (DOUGH.get(choice)) {
                case THIN_DOUGH:
                    ORDER.add(IngredientPriceUtil.priceThinDoughIncludingVAT());
                    INGREDIENT_CALORIES.add(Ingredient.THIN_DOUGH.getCalories());
                    COOK.thinDough();
                    Check.add(CREATE_PIZZA_VIEW.orderThinDough());
                    break;
                case TRADITIONAL_DOUGH:
                    ORDER.add(IngredientPriceUtil.priceTraditionalDoughIncludingVAT());
                    INGREDIENT_CALORIES.add(Ingredient.TRADITIONAL_DOUGH.getCalories());
                    COOK.traditionalDough();
                    Check.add(CREATE_PIZZA_VIEW.orderTraditionalDough());
                    break;
            }
        } catch (NullPointerException e) {
            try {
                throw new DoughException();
            } catch (DoughException ex) {
                CREATE_PIZZA_VIEW.doughException();
                addDoughQuestion();
            }
        }
    }

    public void addDoughQuestion() {
        CREATE_PIZZA_VIEW.addDoughQuestion();
        Scanner scan = new Scanner(System.in);
        ch = scan.next().charAt(0);
        if (ch == 'Y' || ch == 'y') {
            chooseDough();
        } else {
            chooseIngredients();
        }
    }

    public void chooseIngredients() {
        CREATE_PIZZA_VIEW.menuIngredients();
        try {
            choice = CheckUtil.checkInt();
            switch (INGREDIENTS.get(choice)) {
                case CHEESE:
                    ORDER.add(IngredientPriceUtil.priceCheeseIncludingVAT());
                    INGREDIENT_CALORIES.add(Ingredient.CHEESE.getCalories());
                    COOK.cheese();
                    Check.add(CREATE_PIZZA_VIEW.orderCheese());
                    break;
                case MEAT:
                    ORDER.add(IngredientPriceUtil.priceMeatIncludingVAT());
                    INGREDIENT_CALORIES.add(Ingredient.MEAT.getCalories());
                    COOK.meat();
                    Check.add(CREATE_PIZZA_VIEW.orderMeat());
                    break;
                case SAUSAGES:
                    ORDER.add(IngredientPriceUtil.priceSausagesIncludingVAT());
                    INGREDIENT_CALORIES.add(Ingredient.SAUSAGES.getCalories());
                    COOK.sausages();
                    Check.add(CREATE_PIZZA_VIEW.orderSausages());
                    break;
                case OLIVES:
                    ORDER.add(IngredientPriceUtil.priceOlivesIncludingVAT());
                    INGREDIENT_CALORIES.add(Ingredient.OLIVES.getCalories());
                    COOK.olives();
                    Check.add(CREATE_PIZZA_VIEW.orderOlives());
                    break;
                case TOMATOES:
                    ORDER.add(IngredientPriceUtil.priceTomatoesIncludingVAT());
                    INGREDIENT_CALORIES.add(Ingredient.TOMATOES.getCalories());
                    COOK.tomatoes();
                    Check.add(CREATE_PIZZA_VIEW.orderTomatoes());
                    break;
                case PEPPER:
                    ORDER.add(IngredientPriceUtil.pricePepperIncludingVAT());
                    INGREDIENT_CALORIES.add(Ingredient.PEPPER.getCalories());
                    COOK.pepper();
                    Check.add(CREATE_PIZZA_VIEW.orderPepper());
                    break;
                case OREGANO:
                    ORDER.add(IngredientPriceUtil.priceOreganoIncludingVAT());
                    INGREDIENT_CALORIES.add(Ingredient.OREGANO.getCalories());
                    COOK.oregano();
                    Check.add(CREATE_PIZZA_VIEW.orderOregano());
                    break;
                case SAUCE:
                    ORDER.add(IngredientPriceUtil.priceSauceIncludingVAT());
                    INGREDIENT_CALORIES.add(Ingredient.SAUCE.getCalories());
                    COOK.sauce();
                    Check.add(CREATE_PIZZA_VIEW.orderSauce());
                    break;
                case CRUST:
                    ORDER.add(IngredientPriceUtil.priceCrustIncludingVAT());
                    INGREDIENT_CALORIES.add(Ingredient.CRUST.getCalories());
                    Check.add(CREATE_PIZZA_VIEW.orderCrust());
                    break;
            }
        } catch (NullPointerException e) {
            try {
                throw new IngredientNumberException();
            } catch (IngredientNumberException ex) {
                CREATE_PIZZA_VIEW.ingredientNumberException();
            }
        }
        totalOrder();
        CREATE_PIZZA_VIEW.totalCalories(INGREDIENT_CALORIES.countTotalCalories());
    }

    public double totalOrder() {
        return RoundUtil.up(ORDER.totalOrder());
    }

    public void displayTotalOrder() {
        double totalOrder = RoundUtil.up(ORDER.totalOrder());
        CREATE_PIZZA_VIEW.totalOrder(totalOrder);
    }

    public double getChange() {
        return CashPaymentUtil.countChange(totalOrder());
    }

    public void addIngredientsQuestion() {
        CREATE_PIZZA_VIEW.addIngredientsQuestion();
        Scanner scan = new Scanner(System.in);
        ch = scan.next().charAt(0);
        if (ch == 'Y' || ch == 'y') {
            chooseIngredients();
            addIngredientsQuestion();
        } else {
            paymentChoice();
        }
    }

    public void paymentChoice() {
        CREATE_PIZZA_VIEW.paymentChoice();
        try {
            int payment = CheckUtil.checkInt();
            switch (PAYMENT_METHOD.get(payment)) {
                case CASH:
                    CHECK_VIEW.displayCheckCreatePizza();
                    displayTotalOrder();
                    CashPaymentUtil.getFullAmount();
                    CASH_PAYMENT_VIEW.getChangeCreatePizza();
                    break;
                case CARD:
                    CHECK_VIEW.displayCheckCreatePizza();
                    displayTotalOrder();
                    CardPaymentUtil.enterPIN();
                    break;
                case ONLINE:
                    CHECK_VIEW.displayCheckCreatePizza();
                    displayTotalOrder();
                    OnlinePaymentUtil.addCustomer();
                    break;
            }
        } catch (NullPointerException e) {
            try {
                throw new PaymentChoiceException();
            } catch (PaymentChoiceException ex) {
                CREATE_PIZZA_VIEW.paymentChoiceException();
                paymentChoice();
            }
        }
    }
}
