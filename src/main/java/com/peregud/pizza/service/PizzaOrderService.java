package com.peregud.pizza.service;

import com.peregud.pizza.exceptions.PaymentChoiceException;
import com.peregud.pizza.exceptions.PizzaNumberException;
import com.peregud.pizza.model.Check;
import com.peregud.pizza.model.PaymentMethod;
import com.peregud.pizza.model.Pizza;
import com.peregud.pizza.repository.OrderRepository;
import com.peregud.pizza.util.CheckUtil;
import com.peregud.pizza.util.ChoiceUtil;
import com.peregud.pizza.util.DiscountUtil;
import com.peregud.pizza.util.PizzaPriceUtil;
import com.peregud.pizza.view.CashPaymentViewConsole;
import com.peregud.pizza.view.CheckViewConsole;
import com.peregud.pizza.view.PizzaOrderViewConsole;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PizzaOrderService {
    private static final Map<Integer, Pizza> PIZZAS;
    private static final PizzaOrderViewConsole PIZZA_ORDER_VIEW;
    private static final CookService COOK;
    public static final OrderRepository ORDER;
    private static final CashPaymentService CASH_PAYMENT;
    private static final CashPaymentViewConsole CASH_PAYMENT_VIEW;
    public static final Check CHECK;
    private static final CheckViewConsole CHECK_VIEW;
    private static final OnlinePaymentService ONLINE_PAYMENT;
    private static final CardPaymentService CARD_PAYMENT;
    private static final Map<Integer, PaymentMethod> PAYMENT_METHOD;
    public int payment;
    public char ch;
    public int choice;

    static {
        PIZZAS = new HashMap<>();
        PIZZAS.put(1, Pizza.FOUR_CHEESE);
        PIZZAS.put(2, Pizza.MARGHERITA);
        PIZZAS.put(3, Pizza.MEAT_DELIGHT);
        PIZZAS.put(4, Pizza.PEPPERONI);
        PIZZAS.put(5, Pizza.VEGETARIAN);

        PIZZA_ORDER_VIEW = new PizzaOrderViewConsole();
        COOK = new CookService();
        CASH_PAYMENT = new CashPaymentService();
        CASH_PAYMENT_VIEW = new CashPaymentViewConsole();
        CHECK = new Check(new ArrayList<>());
        CHECK_VIEW = new CheckViewConsole();
        ONLINE_PAYMENT = new OnlinePaymentService();
        CARD_PAYMENT = new CardPaymentService();
        ORDER = new OrderRepository(new ArrayList<>());

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

    public void choosePizza() {
        PIZZA_ORDER_VIEW.pizzaMenu();
        choice = CheckUtil.checkInt();
        try {
            switch (PIZZAS.get(choice)) {
                case FOUR_CHEESE:
                    PIZZA_ORDER_VIEW.orderPizzaFourCheese();
                    PIZZA_ORDER_VIEW.displayInfoPizzaFourCheese();
                    COOK.pizzaFourCheese();
                    CHECK.add(PIZZA_ORDER_VIEW.orderPizzaFourCheese());
                    ORDER.add(PizzaPriceUtil.pricePizzaFourCheeseIncludingVAT());
                    showOrderInfo();
                    PIZZA_ORDER_VIEW.addSupplementIngredients();
                    ChoiceUtil.addChoiceQuestion();
                    break;
                case MARGHERITA:
                    PIZZA_ORDER_VIEW.orderPizzaMargherita();
                    PIZZA_ORDER_VIEW.displayInfoPizzaMargherita();
                    COOK.pizzaMargherita();
                    CHECK.add(PIZZA_ORDER_VIEW.orderPizzaMargherita());
                    ORDER.add(PizzaPriceUtil.pricePizzaMargheritaIncludingVAT());
                    showOrderInfo();
                    PIZZA_ORDER_VIEW.addSupplementIngredients();
                    ChoiceUtil.addChoiceQuestion();
                    break;
                case MEAT_DELIGHT:
                    PIZZA_ORDER_VIEW.orderPizzaMeatDelight();
                    PIZZA_ORDER_VIEW.displayInfoPizzaMeatDelight();
                    COOK.pizzaMeatDelight();
                    CHECK.add(PIZZA_ORDER_VIEW.orderPizzaMeatDelight());
                    ORDER.add(PizzaPriceUtil.pricePizzaMeatDelightIncludingVAT());
                    showOrderInfo();
                    PIZZA_ORDER_VIEW.addSupplementIngredients();
                    ChoiceUtil.addChoiceQuestion();
                    break;
                case PEPPERONI:
                    PIZZA_ORDER_VIEW.orderPizzaPepperoni();
                    PIZZA_ORDER_VIEW.displayInfoPizzaPepperoni();
                    COOK.pizzaPepperoni();
                    CHECK.add(PIZZA_ORDER_VIEW.orderPizzaPepperoni());
                    ORDER.add(PizzaPriceUtil.pricePizzaPepperoniIncludingVAT());
                    showOrderInfo();
                    PIZZA_ORDER_VIEW.addSupplementIngredients();
                    ChoiceUtil.addChoiceQuestion();
                    break;
                case VEGETARIAN:
                    PIZZA_ORDER_VIEW.orderPizzaVegetarian();
                    PIZZA_ORDER_VIEW.displayInfoPizzaVegetarian();
                    COOK.pizzaVegetarian();
                    CHECK.add(PIZZA_ORDER_VIEW.orderPizzaVegetarian());
                    ORDER.add(PizzaPriceUtil.pricePizzaVegetarianIncludingVAT());
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
        amountToPay(ORDER.totalOrder());
    }

    public void totalOrder() {
        double totalOrder = ORDER.totalOrder();
        int size = ORDER.size();
        PIZZA_ORDER_VIEW.totalOrder(totalOrder, size);
    }

    public void discountForTwoItems() {
        if (ORDER.size() == 2) {
            double totalOrder = DiscountUtil.discountForTwoItems(ORDER.totalOrder());
            PIZZA_ORDER_VIEW.discountFor2Pizzas(totalOrder);
        }
    }

    public void discountForThreeAndMoreItems() {
        if (ORDER.size() >= 3) {
            double totalOrder = DiscountUtil.discountForThreeAndMoreItems(ORDER.totalOrder());
            PIZZA_ORDER_VIEW.discountFor3AndMorePizzas(totalOrder);
        }
    }

    public void discountForOrderOnSpecificDay() {
        if (ORDER.size() == 1 && LocalDateTime.now().getDayOfWeek() == DayOfWeek.FRIDAY) {
            double totalOrder = DiscountUtil.discountForOrderOnSpecificDay(ORDER.totalOrder());
            PIZZA_ORDER_VIEW.discountForOrderOnSpecificDay(totalOrder);
            PIZZA_ORDER_VIEW.amountToPay(DiscountUtil.discountForOrderOnSpecificDay(
                    ORDER.totalOrder()));
        } else if (LocalDateTime.now().getDayOfWeek() == DayOfWeek.FRIDAY) {
            double totalOrder = DiscountUtil.discountForOrderOnSpecificDay(ORDER.totalOrder());
            PIZZA_ORDER_VIEW.discountForOrderOnSpecificDay(totalOrder);
        }
    }

    public double amountToPay(double amountToPay) {
        if (ORDER.size() == 2 && LocalDateTime.now().getDayOfWeek() != DayOfWeek.FRIDAY) {
            amountToPay = DiscountUtil.discountForTwoItems(ORDER.totalOrder());
        } else if (ORDER.size() == 2 && LocalDateTime.now().getDayOfWeek() == DayOfWeek.FRIDAY) {
            amountToPay = DiscountUtil.amountToPayFor2PizzasOnSpecificDay(
                    ORDER.totalOrder());
        } else if (ORDER.size() >= 3 && LocalDateTime.now().getDayOfWeek() != DayOfWeek.FRIDAY) {
            amountToPay = DiscountUtil.discountForThreeAndMoreItems(
                    ORDER.totalOrder());
        } else if (ORDER.size() >= 3 && LocalDateTime.now().getDayOfWeek() == DayOfWeek.FRIDAY) {
            amountToPay = DiscountUtil.amountToPayFor3AndMorePizzasOnSpecificDay(
                    ORDER.totalOrder());
        }
        return amountToPay;
    }

    public void createCheck() {
        if (ORDER.size() == 2 && LocalDateTime.now().getDayOfWeek() != DayOfWeek.FRIDAY) {
            PIZZA_ORDER_VIEW.amountToPay(DiscountUtil.discountForTwoItems(ORDER.totalOrder()));
        } else if (ORDER.size() == 2 && LocalDateTime.now().getDayOfWeek() == DayOfWeek.FRIDAY) {
            PIZZA_ORDER_VIEW.amountToPay(DiscountUtil.amountToPayFor2PizzasOnSpecificDay(
                    ORDER.totalOrder()));
        } else if (ORDER.size() >= 3 && LocalDateTime.now().getDayOfWeek() != DayOfWeek.FRIDAY) {
            PIZZA_ORDER_VIEW.amountToPay(DiscountUtil.discountForThreeAndMoreItems(
                    ORDER.totalOrder()));
        } else if (ORDER.size() >= 3 && LocalDateTime.now().getDayOfWeek() == DayOfWeek.FRIDAY) {
            PIZZA_ORDER_VIEW.amountToPay(DiscountUtil.amountToPayFor3AndMorePizzasOnSpecificDay(
                    ORDER.totalOrder()));
        }
    }

    public void addPizzaQuestion() throws IOException {
        PIZZA_ORDER_VIEW.addPizzaQuestion();
        Scanner scan = new Scanner(System.in);
        ch = scan.next().charAt(0);
        if (ch == 'Y' || ch == 'y') {
            choosePizza();
            addPizzaQuestion();
        } else {
            paymentChoice();
        }
    }

    public double getChange() {
        return CASH_PAYMENT.countChange(amountToPay(ORDER.totalOrder()));
    }

    public void paymentChoice() throws IOException {
        CHECK.checkInFile();
        PIZZA_ORDER_VIEW.paymentChoice();
        try {
            payment = CheckUtil.checkInt();
            switch (PAYMENT_METHOD.get(payment)) {
                case CASH:
                    CHECK_VIEW.displayCheckPizzaOrder();
                    createCheck();
                    CASH_PAYMENT.getFullAmount();
                    CASH_PAYMENT_VIEW.getChangePizzaOrder();
                    break;
                case CARD:
                    CHECK_VIEW.displayCheckPizzaOrder();
                    createCheck();
                    CARD_PAYMENT.enterPIN();
                    break;
                case ONLINE:
                    CHECK_VIEW.displayCheckPizzaOrder();
                    createCheck();
                    ONLINE_PAYMENT.addCustomer();
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
