package com.peregud.pizza.util;

import com.peregud.pizza.model.Check;
import com.peregud.pizza.model.Order;
import com.peregud.pizza.model.Pizza;
import com.peregud.pizza.service.PizzaOrderCalculatorService;
import com.peregud.pizza.view.PizzaOrderView;
import com.peregud.pizza.view.PizzaOrderViewConsole;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public final class OrderPizzaUtil {
    private static final PizzaOrderView PIZZA_ORDER_VIEW;
    private static final List<Order> ORDER_LIST;
    private static final Order ORDER;
    private static final PizzaOrderCalculatorService PIZZA_ORDER;

    static {
        PIZZA_ORDER_VIEW = new PizzaOrderViewConsole();
        ORDER_LIST = new ArrayList<>();
        ORDER = new Order();
        PIZZA_ORDER = new PizzaOrderCalculatorService(new ArrayList<>());
    }

    private OrderPizzaUtil() {
    }

    public static void addToOrder(String pizzaName, double price) {
        getOrderList().add(ORDER.add(pizzaName, RoundUtil.up(price),
                DateFormatUtil.localDatePattern(LocalDateTime.now())));
    }

    public static void orderFourCheese() {
        PIZZA_ORDER_VIEW.orderPizza(Pizza.FOUR_CHEESE, PizzaPriceUtil.pricePizzaFourCheeseIncludingVAT());
        CookUtil.cookPizza(Pizza.FOUR_CHEESE);
        Check.add(PIZZA_ORDER_VIEW.orderPizza(Pizza.FOUR_CHEESE, PizzaPriceUtil.pricePizzaFourCheeseIncludingVAT()));
        addToOrder(Pizza.FOUR_CHEESE.name(), PizzaPriceUtil.pricePizzaFourCheeseIncludingVAT());
        PIZZA_ORDER.add(PizzaPriceUtil.pricePizzaFourCheeseIncludingVAT());
        additionalInfo();
    }

    public static void orderMargherita() {
        PIZZA_ORDER_VIEW.orderPizza(Pizza.MARGHERITA, PizzaPriceUtil.pricePizzaMargheritaIncludingVAT());
        CookUtil.cookPizza(Pizza.MARGHERITA);
        Check.add(PIZZA_ORDER_VIEW.orderPizza(Pizza.MARGHERITA, PizzaPriceUtil.pricePizzaMargheritaIncludingVAT()));
        addToOrder(Pizza.MARGHERITA.name(), PizzaPriceUtil.pricePizzaMargheritaIncludingVAT());
        PIZZA_ORDER.add(PizzaPriceUtil.pricePizzaMargheritaIncludingVAT());
        additionalInfo();
    }

    public static void orderMeatDelight() {
        PIZZA_ORDER_VIEW.orderPizza(Pizza.MEAT_DELIGHT, PizzaPriceUtil.pricePizzaMeatDelightIncludingVAT());
        CookUtil.cookPizza(Pizza.MEAT_DELIGHT);
        Check.add(PIZZA_ORDER_VIEW.orderPizza(Pizza.MEAT_DELIGHT, PizzaPriceUtil.pricePizzaMeatDelightIncludingVAT()));
        addToOrder(Pizza.MEAT_DELIGHT.name(), PizzaPriceUtil.pricePizzaMeatDelightIncludingVAT());
        PIZZA_ORDER.add(PizzaPriceUtil.pricePizzaMeatDelightIncludingVAT());
        additionalInfo();
    }

    public static void orderPepperoni() {
        PIZZA_ORDER_VIEW.orderPizza(Pizza.PEPPERONI, PizzaPriceUtil.pricePizzaPepperoniIncludingVAT());
        CookUtil.cookPizza(Pizza.PEPPERONI);
        Check.add(PIZZA_ORDER_VIEW.orderPizza(Pizza.PEPPERONI, PizzaPriceUtil.pricePizzaPepperoniIncludingVAT()));
        addToOrder(Pizza.PEPPERONI.name(), PizzaPriceUtil.pricePizzaPepperoniIncludingVAT());
        PIZZA_ORDER.add(PizzaPriceUtil.pricePizzaPepperoniIncludingVAT());
        additionalInfo();
    }

    public static void orderVegetarian() {
        PIZZA_ORDER_VIEW.orderPizza(Pizza.VEGETARIAN, PizzaPriceUtil.pricePizzaVegetarianIncludingVAT());
        CookUtil.cookPizza(Pizza.VEGETARIAN);
        Check.add(PIZZA_ORDER_VIEW.orderPizza(Pizza.VEGETARIAN, PizzaPriceUtil.pricePizzaVegetarianIncludingVAT()));
        addToOrder(Pizza.VEGETARIAN.name(), PizzaPriceUtil.pricePizzaVegetarianIncludingVAT());
        PIZZA_ORDER.add(PizzaPriceUtil.pricePizzaVegetarianIncludingVAT());
        additionalInfo();
    }

    public static void additionalInfo() {
        TotalOrderCalculatorUtil.totalOrder();
        PIZZA_ORDER_VIEW.addSupplementIngredients();
        ChoiceUtil.addChoiceQuestion();
    }

    public static PizzaOrderView getPizzaOrderView() {
        return PIZZA_ORDER_VIEW;
    }

    public static List<Order> getOrderList() {
        return ORDER_LIST;
    }

    public static PizzaOrderCalculatorService getPizzaOrder() {
        return PIZZA_ORDER;
    }
}
