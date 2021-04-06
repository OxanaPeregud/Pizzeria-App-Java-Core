package com.peregud.pizza.service;

import com.peregud.pizza.exceptions.PaymentChoiceException;
import com.peregud.pizza.exceptions.PizzaNumberException;
import com.peregud.pizza.model.Check;
import com.peregud.pizza.model.PaymentMethod;
import com.peregud.pizza.model.Pizza;
import com.peregud.pizza.repository.IngredientOrderRepository;
import com.peregud.pizza.repository.PizzaOrderRepository;
import com.peregud.pizza.util.*;
import com.peregud.pizza.view.*;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PizzaOrderService {
    private static final Map<Integer, Pizza> PIZZAS;
    private static final PizzaOrderView PIZZA_ORDER_VIEW;
    private static final CookService COOK;
    private static final CashPaymentView CASH_PAYMENT_VIEW;
    public static final Check CHECK;
    private static final CheckView CHECK_VIEW;
    private static final Map<Integer, PaymentMethod> PAYMENT_METHOD;
    private static final PizzaOrderRepository PIZZA_ORDER;
    public static final IngredientOrderRepository INGREDIENT_ORDER;
    private static final CreatePizzaService CREATE_PIZZA;

    static {
        PIZZAS = new HashMap<>();
        PIZZAS.put(1, Pizza.FOUR_CHEESE);
        PIZZAS.put(2, Pizza.MARGHERITA);
        PIZZAS.put(3, Pizza.MEAT_DELIGHT);
        PIZZAS.put(4, Pizza.PEPPERONI);
        PIZZAS.put(5, Pizza.VEGETARIAN);

        PIZZA_ORDER_VIEW = new PizzaOrderViewConsole();
        COOK = new CookService();
        CASH_PAYMENT_VIEW = new CashPaymentViewConsole();
        CHECK = new Check(new ArrayList<>());
        CHECK_VIEW = new CheckViewConsole();
        PIZZA_ORDER = new PizzaOrderRepository(new ArrayList<>());
        INGREDIENT_ORDER = new IngredientOrderRepository(new ArrayList<>());
        CREATE_PIZZA = new CreatePizzaService();

        PAYMENT_METHOD = new HashMap<>();
        PAYMENT_METHOD.put(1, PaymentMethod.CASH);
        PAYMENT_METHOD.put(2, PaymentMethod.CARD);
        PAYMENT_METHOD.put(3, PaymentMethod.ONLINE);
    }

    public PizzaOrderService() {
    }

    public void start() {
        PIZZA_ORDER_VIEW.greeting();
    }

    public void displayOptions() {
        PIZZA_ORDER_VIEW.displayOptions();
        int choice = CheckUtil.checkInt();
        switch (choice) {
            case 1:
                choosePizza();
                break;
            case 2:
                PIZZA_ORDER_VIEW.displayInfoPizzaFourCheese();
                PIZZA_ORDER_VIEW.displayInfoPizzaMargherita();
                PIZZA_ORDER_VIEW.displayInfoPizzaMeatDelight();
                PIZZA_ORDER_VIEW.displayInfoPizzaPepperoni();
                PIZZA_ORDER_VIEW.displayInfoPizzaVegetarian();
                displayOptions();
                break;
            case 3:
                CREATE_PIZZA.start();
                CREATE_PIZZA.chooseDough();
                CREATE_PIZZA.chooseIngredients();
                CREATE_PIZZA.addIngredientsQuestion();
                break;
            case 4:
                break;
            default:
                PIZZA_ORDER_VIEW.choiceView();
                displayOptions();
                break;
        }
    }

    public void choosePizza() {
        PIZZA_ORDER_VIEW.pizzaMenu();
        int choice = CheckUtil.checkInt();
        try {
            switch (PIZZAS.get(choice)) {
                case FOUR_CHEESE:
                    PIZZA_ORDER_VIEW.orderPizzaFourCheese();
                    COOK.pizzaFourCheese();
                    CHECK.add(PIZZA_ORDER_VIEW.orderPizzaFourCheese());
                    PIZZA_ORDER.add(PizzaPriceUtil.pricePizzaFourCheeseIncludingVAT());
                    showOrderInfo();
                    PIZZA_ORDER_VIEW.addSupplementIngredients();
                    ChoiceUtil.addChoiceQuestion();
                    break;
                case MARGHERITA:
                    PIZZA_ORDER_VIEW.orderPizzaMargherita();
                    COOK.pizzaMargherita();
                    CHECK.add(PIZZA_ORDER_VIEW.orderPizzaMargherita());
                    PIZZA_ORDER.add(PizzaPriceUtil.pricePizzaMargheritaIncludingVAT());
                    showOrderInfo();
                    PIZZA_ORDER_VIEW.addSupplementIngredients();
                    ChoiceUtil.addChoiceQuestion();
                    break;
                case MEAT_DELIGHT:
                    PIZZA_ORDER_VIEW.orderPizzaMeatDelight();
                    COOK.pizzaMeatDelight();
                    CHECK.add(PIZZA_ORDER_VIEW.orderPizzaMeatDelight());
                    PIZZA_ORDER.add(PizzaPriceUtil.pricePizzaMeatDelightIncludingVAT());
                    showOrderInfo();
                    PIZZA_ORDER_VIEW.addSupplementIngredients();
                    ChoiceUtil.addChoiceQuestion();
                    break;
                case PEPPERONI:
                    PIZZA_ORDER_VIEW.orderPizzaPepperoni();
                    COOK.pizzaPepperoni();
                    CHECK.add(PIZZA_ORDER_VIEW.orderPizzaPepperoni());
                    PIZZA_ORDER.add(PizzaPriceUtil.pricePizzaPepperoniIncludingVAT());
                    showOrderInfo();
                    PIZZA_ORDER_VIEW.addSupplementIngredients();
                    ChoiceUtil.addChoiceQuestion();
                    break;
                case VEGETARIAN:
                    PIZZA_ORDER_VIEW.orderPizzaVegetarian();
                    COOK.pizzaVegetarian();
                    CHECK.add(PIZZA_ORDER_VIEW.orderPizzaVegetarian());
                    PIZZA_ORDER.add(PizzaPriceUtil.pricePizzaVegetarianIncludingVAT());
                    showOrderInfo();
                    PIZZA_ORDER_VIEW.addSupplementIngredients();
                    ChoiceUtil.addChoiceQuestion();
                    break;
            }
        } catch (NullPointerException | IOException e) {
            try {
                throw new PizzaNumberException();
            } catch (PizzaNumberException ex) {
                PIZZA_ORDER_VIEW.pizzaNumberException();
            }
        }
    }

    public void showOrderInfo() {
        totalOrder();
        discountForTwoItems();
        discountForThreeAndMoreItems();
        discountForOrderOnSpecificDay();
        amountToPay(PIZZA_ORDER.totalOrder() + INGREDIENT_ORDER.totalOrder());
    }

    public void totalOrder() {
        double totalOrder = PIZZA_ORDER.totalOrder() + INGREDIENT_ORDER.totalOrder();
        int size = PIZZA_ORDER.size();
        PIZZA_ORDER_VIEW.totalOrder(totalOrder, size);
    }

    public void discountForTwoItems() {
        if (PIZZA_ORDER.size() == 2) {
            double totalOrder = DiscountUtil.discountForTwoItems(PIZZA_ORDER.totalOrder());
            PIZZA_ORDER_VIEW.discountFor2Pizzas(totalOrder);
        }
    }

    public void discountForThreeAndMoreItems() {
        if (PIZZA_ORDER.size() >= 3) {
            double totalOrder = DiscountUtil.discountForThreeAndMoreItems(PIZZA_ORDER.totalOrder());
            PIZZA_ORDER_VIEW.discountFor3AndMorePizzas(totalOrder);
        }
    }

    public void discountForOrderOnSpecificDay() {
        if (PIZZA_ORDER.size() == 1 && LocalDateTime.now().getDayOfWeek() == DayOfWeek.FRIDAY) {
            double totalOrder = DiscountUtil.discountForOrderOnSpecificDay(PIZZA_ORDER.totalOrder()) +
                    INGREDIENT_ORDER.totalOrder();
            PIZZA_ORDER_VIEW.discountForOrderOnSpecificDay(totalOrder);
            PIZZA_ORDER_VIEW.amountToPay(DiscountUtil.discountForOrderOnSpecificDay(
                    PIZZA_ORDER.totalOrder()) + INGREDIENT_ORDER.totalOrder());
        } else if (LocalDateTime.now().getDayOfWeek() == DayOfWeek.FRIDAY) {
            double totalOrder = DiscountUtil.discountForOrderOnSpecificDay(PIZZA_ORDER.totalOrder()) +
                    INGREDIENT_ORDER.totalOrder();
            PIZZA_ORDER_VIEW.discountForOrderOnSpecificDay(totalOrder);
        }
    }

    public double amountToPay(double amountToPay) {
        if (PIZZA_ORDER.size() == 2 && LocalDateTime.now().getDayOfWeek() != DayOfWeek.FRIDAY) {
            amountToPay = DiscountUtil.discountForTwoItems(PIZZA_ORDER.totalOrder()) +
                    INGREDIENT_ORDER.totalOrder();
        } else if (PIZZA_ORDER.size() == 2 && LocalDateTime.now().getDayOfWeek() == DayOfWeek.FRIDAY) {
            amountToPay = DiscountUtil.amountToPayFor2PizzasOnSpecificDay(
                    PIZZA_ORDER.totalOrder()) + INGREDIENT_ORDER.totalOrder();
        } else if (PIZZA_ORDER.size() >= 3 && LocalDateTime.now().getDayOfWeek() != DayOfWeek.FRIDAY) {
            amountToPay = DiscountUtil.discountForThreeAndMoreItems(
                    PIZZA_ORDER.totalOrder()) + INGREDIENT_ORDER.totalOrder();
        } else if (PIZZA_ORDER.size() >= 3 && LocalDateTime.now().getDayOfWeek() == DayOfWeek.FRIDAY) {
            amountToPay = DiscountUtil.amountToPayFor3AndMorePizzasOnSpecificDay(
                    PIZZA_ORDER.totalOrder()) + INGREDIENT_ORDER.totalOrder();
        }
        return amountToPay;
    }

    public void createCheck() {
        if (PIZZA_ORDER.size() == 2 && LocalDateTime.now().getDayOfWeek() != DayOfWeek.FRIDAY) {
            PIZZA_ORDER_VIEW.amountToPay(DiscountUtil.discountForTwoItems(PIZZA_ORDER.totalOrder()) +
                    INGREDIENT_ORDER.totalOrder());
        } else if (PIZZA_ORDER.size() == 2 && LocalDateTime.now().getDayOfWeek() == DayOfWeek.FRIDAY) {
            PIZZA_ORDER_VIEW.amountToPay(DiscountUtil.amountToPayFor2PizzasOnSpecificDay(
                    PIZZA_ORDER.totalOrder()) + INGREDIENT_ORDER.totalOrder());
        } else if (PIZZA_ORDER.size() >= 3 && LocalDateTime.now().getDayOfWeek() != DayOfWeek.FRIDAY) {
            PIZZA_ORDER_VIEW.amountToPay(DiscountUtil.discountForThreeAndMoreItems(
                    PIZZA_ORDER.totalOrder()) + INGREDIENT_ORDER.totalOrder());
        } else if (PIZZA_ORDER.size() >= 3 && LocalDateTime.now().getDayOfWeek() == DayOfWeek.FRIDAY) {
            PIZZA_ORDER_VIEW.amountToPay(DiscountUtil.amountToPayFor3AndMorePizzasOnSpecificDay(
                    PIZZA_ORDER.totalOrder()) + INGREDIENT_ORDER.totalOrder());
        }
    }

    public double getChange() {
        return CashPaymentUtil.countChange(amountToPay(PIZZA_ORDER.totalOrder() +
                INGREDIENT_ORDER.totalOrder()));
    }

    public void paymentChoice() throws IOException {
        CHECK.checkInFile();
        PIZZA_ORDER_VIEW.paymentChoice();
        try {
            int payment = CheckUtil.checkInt();
            switch (PAYMENT_METHOD.get(payment)) {
                case CASH:
                    CHECK_VIEW.displayCheckPizzaOrder();
                    createCheck();
                    CashPaymentUtil.getFullAmount();
                    CASH_PAYMENT_VIEW.getChangePizzaOrder();
                    break;
                case CARD:
                    CHECK_VIEW.displayCheckPizzaOrder();
                    createCheck();
                    CardPaymentUtil.enterPIN();
                    break;
                case ONLINE:
                    CHECK_VIEW.displayCheckPizzaOrder();
                    createCheck();
                    OnlinePaymentUtil.addCustomer();
                    break;
            }
        } catch (NullPointerException e) {
            try {
                throw new PaymentChoiceException();
            } catch (PaymentChoiceException ex) {
                PIZZA_ORDER_VIEW.paymentChoiceException();
                paymentChoice();
            }
        }
    }
}
