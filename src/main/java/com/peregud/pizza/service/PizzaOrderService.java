package com.peregud.pizza.service;

import com.peregud.pizza.exceptions.PaymentChoiceException;
import com.peregud.pizza.exceptions.PizzaNumberException;
import com.peregud.pizza.model.Check;
import com.peregud.pizza.model.PaymentMethod;
import com.peregud.pizza.model.Pizza;
import com.peregud.pizza.repository.OrderRepository;
import com.peregud.pizza.repository.OrderRepositorySQL;
import com.peregud.pizza.util.*;
import com.peregud.pizza.view.*;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PizzaOrderService {
    private static final Map<Integer, Pizza> PIZZAS;
    private static final PizzaOrderView PIZZA_ORDER_VIEW;
    private static final CashPaymentView CASH_PAYMENT_VIEW;
    public static final Check CHECK;
    private static final CheckView CHECK_VIEW;
    private static final Map<Integer, PaymentMethod> PAYMENT_METHOD;
    public static final IngredientOrderCalculatorService INGREDIENT_ORDER;
    private static final CreatePizzaService CREATE_PIZZA;
    private static final OrderRepository ORDER_REPOSITORY;

    static {
        PIZZAS = new HashMap<>();
        PIZZAS.put(1, Pizza.FOUR_CHEESE);
        PIZZAS.put(2, Pizza.MARGHERITA);
        PIZZAS.put(3, Pizza.MEAT_DELIGHT);
        PIZZAS.put(4, Pizza.PEPPERONI);
        PIZZAS.put(5, Pizza.VEGETARIAN);

        PIZZA_ORDER_VIEW = new PizzaOrderViewConsole();
        CASH_PAYMENT_VIEW = new CashPaymentViewConsole();
        CHECK = new Check(new ArrayList<>());
        CHECK_VIEW = new CheckViewConsole();
        INGREDIENT_ORDER = new IngredientOrderCalculatorService(new ArrayList<>());
        CREATE_PIZZA = new CreatePizzaService();
        ORDER_REPOSITORY = new OrderRepositorySQL();

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
                PIZZA_ORDER_VIEW.displayInfoPizza();
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
                    OrderUtil.orderFourCheese();
                    showOrderInfo();
                    break;
                case MARGHERITA:
                    OrderUtil.orderMargherita();
                    showOrderInfo();
                    break;
                case MEAT_DELIGHT:
                    OrderUtil.orderMeatDelight();
                    showOrderInfo();
                    break;
                case PEPPERONI:
                    OrderUtil.orderPepperoni();
                    showOrderInfo();
                    break;
                case VEGETARIAN:
                    OrderUtil.orderVegetarian();
                    showOrderInfo();
                    break;
            }
        } catch (NullPointerException e) {
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
        amountToPay(OrderUtil.getPizzaOrder().totalOrder() + INGREDIENT_ORDER.totalOrder());
    }

    public void totalOrder() {
        double totalOrder = OrderUtil.getPizzaOrder().totalOrder() + INGREDIENT_ORDER.totalOrder();
        int size = OrderUtil.getPizzaOrder().size();
        OrderUtil.getPizzaOrderView().totalOrder(totalOrder, size);
    }

    public void discountForTwoItems() {
        if (OrderUtil.getPizzaOrder().size() == 2) {
            double totalOrder = DiscountUtil.discountForTwoItems(OrderUtil.getPizzaOrder().totalOrder());
            OrderUtil.getPizzaOrderView().discountFor2Pizzas(totalOrder);
        }
    }

    public void discountForThreeAndMoreItems() {
        if (OrderUtil.getPizzaOrder().size() >= 3) {
            double totalOrder = DiscountUtil.discountForThreeAndMoreItems(OrderUtil.getPizzaOrder().totalOrder());
            OrderUtil.getPizzaOrderView().discountFor3AndMorePizzas(totalOrder);
        }
    }

    public void discountForOrderOnSpecificDay() {
        if (OrderUtil.getPizzaOrder().size() == 1 && LocalDateTime.now().getDayOfWeek() == DayOfWeek.FRIDAY) {
            double totalOrder = DiscountUtil.discountForOrderOnSpecificDay(OrderUtil.getPizzaOrder().totalOrder()) +
                    INGREDIENT_ORDER.totalOrder();
            OrderUtil.getPizzaOrderView().discountForOrderOnSpecificDay(totalOrder);
            OrderUtil.getPizzaOrderView().amountToPay(DiscountUtil.discountForOrderOnSpecificDay(
                    OrderUtil.getPizzaOrder().totalOrder()) + INGREDIENT_ORDER.totalOrder());
        } else if (LocalDateTime.now().getDayOfWeek() == DayOfWeek.FRIDAY) {
            double totalOrder = DiscountUtil.discountForOrderOnSpecificDay(OrderUtil.getPizzaOrder().totalOrder()) +
                    INGREDIENT_ORDER.totalOrder();
            OrderUtil.getPizzaOrderView().discountForOrderOnSpecificDay(totalOrder);
        }
    }

    public double amountToPay(double amountToPay) {
        if (OrderUtil.getPizzaOrder().size() == 2 && LocalDateTime.now().getDayOfWeek() != DayOfWeek.FRIDAY) {
            amountToPay = DiscountUtil.discountForTwoItems(OrderUtil.getPizzaOrder().totalOrder()) +
                    INGREDIENT_ORDER.totalOrder();
        } else if (OrderUtil.getPizzaOrder().size() == 2 && LocalDateTime.now().getDayOfWeek() == DayOfWeek.FRIDAY) {
            amountToPay = DiscountUtil.amountToPayFor2PizzasOnSpecificDay(
                    OrderUtil.getPizzaOrder().totalOrder()) + INGREDIENT_ORDER.totalOrder();
        } else if (OrderUtil.getPizzaOrder().size() >= 3 && LocalDateTime.now().getDayOfWeek() != DayOfWeek.FRIDAY) {
            amountToPay = DiscountUtil.discountForThreeAndMoreItems(
                    OrderUtil.getPizzaOrder().totalOrder()) + INGREDIENT_ORDER.totalOrder();
        } else if (OrderUtil.getPizzaOrder().size() >= 3 && LocalDateTime.now().getDayOfWeek() == DayOfWeek.FRIDAY) {
            amountToPay = DiscountUtil.amountToPayFor3AndMorePizzasOnSpecificDay(
                    OrderUtil.getPizzaOrder().totalOrder()) + INGREDIENT_ORDER.totalOrder();
        }
        return amountToPay;
    }

    public void createCheck() {
        if (OrderUtil.getPizzaOrder().size() == 2 && LocalDateTime.now().getDayOfWeek() != DayOfWeek.FRIDAY) {
            OrderUtil.getPizzaOrderView().amountToPay(DiscountUtil.discountForTwoItems(OrderUtil.getPizzaOrder()
                    .totalOrder()) + INGREDIENT_ORDER.totalOrder());
        } else if (OrderUtil.getPizzaOrder().size() == 2 && LocalDateTime.now().getDayOfWeek() == DayOfWeek.FRIDAY) {
            OrderUtil.getPizzaOrderView().amountToPay(DiscountUtil.amountToPayFor2PizzasOnSpecificDay(
                    OrderUtil.getPizzaOrder().totalOrder()) + INGREDIENT_ORDER.totalOrder());
        } else if (OrderUtil.getPizzaOrder().size() >= 3 && LocalDateTime.now().getDayOfWeek() != DayOfWeek.FRIDAY) {
            OrderUtil.getPizzaOrderView().amountToPay(DiscountUtil.discountForThreeAndMoreItems(
                    OrderUtil.getPizzaOrder().totalOrder()) + INGREDIENT_ORDER.totalOrder());
        } else if (OrderUtil.getPizzaOrder().size() >= 3 && LocalDateTime.now().getDayOfWeek() == DayOfWeek.FRIDAY) {
            OrderUtil.getPizzaOrderView().amountToPay(DiscountUtil.amountToPayFor3AndMorePizzasOnSpecificDay(
                    OrderUtil.getPizzaOrder().totalOrder()) + INGREDIENT_ORDER.totalOrder());
        }
    }

    public double getChange() {
        return CashPaymentUtil.countChange(amountToPay(OrderUtil.getPizzaOrder().totalOrder() +
                INGREDIENT_ORDER.totalOrder()));
    }

    public void paymentChoice() {
        ORDER_REPOSITORY.orderInput(OrderUtil.getOrderList());
        OrderUtil.getPizzaOrderView().paymentChoice();
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
