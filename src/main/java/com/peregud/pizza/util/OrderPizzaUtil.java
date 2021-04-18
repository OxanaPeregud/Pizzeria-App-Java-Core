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

    public static void orderFourCheese() {
        PIZZA_ORDER_VIEW.orderPizzaFourCheese();
        CookUtil.pizzaFourCheese();
        Check.add(PIZZA_ORDER_VIEW.orderPizzaFourCheese());
        ORDER_LIST.add(ORDER.add(Pizza.FOUR_CHEESE.name(), RoundUtil.up(
                PizzaPriceUtil.pricePizzaFourCheeseIncludingVAT()),
                DateFormatUtil.localDatePattern(LocalDateTime.now())));
        PIZZA_ORDER.add(PizzaPriceUtil.pricePizzaFourCheeseIncludingVAT());
        DisplayOrderInfoUtil.showOrderInfo();
        PIZZA_ORDER_VIEW.addSupplementIngredients();
        ChoiceUtil.addChoiceQuestion();
    }

    public static void orderMargherita() {
        PIZZA_ORDER_VIEW.orderPizzaMargherita();
        CookUtil.pizzaMargherita();
        Check.add(PIZZA_ORDER_VIEW.orderPizzaMargherita());
        ORDER_LIST.add(ORDER.add(Pizza.MARGHERITA.name(), RoundUtil.up(
                PizzaPriceUtil.pricePizzaMargheritaIncludingVAT()),
                DateFormatUtil.localDatePattern(LocalDateTime.now())));
        PIZZA_ORDER.add(PizzaPriceUtil.pricePizzaMargheritaIncludingVAT());
        DisplayOrderInfoUtil.showOrderInfo();
        PIZZA_ORDER_VIEW.addSupplementIngredients();
        ChoiceUtil.addChoiceQuestion();
    }

    public static void orderMeatDelight() {
        PIZZA_ORDER_VIEW.orderPizzaMeatDelight();
        CookUtil.pizzaMeatDelight();
        Check.add(PIZZA_ORDER_VIEW.orderPizzaMeatDelight());
        ORDER_LIST.add(ORDER.add(Pizza.MEAT_DELIGHT.name(),
                RoundUtil.up(PizzaPriceUtil.pricePizzaMeatDelightIncludingVAT()),
                DateFormatUtil.localDatePattern(LocalDateTime.now())));
        PIZZA_ORDER.add(PizzaPriceUtil.pricePizzaMeatDelightIncludingVAT());
        DisplayOrderInfoUtil.showOrderInfo();
        PIZZA_ORDER_VIEW.addSupplementIngredients();
        ChoiceUtil.addChoiceQuestion();
    }

    public static void orderPepperoni() {
        PIZZA_ORDER_VIEW.orderPizzaPepperoni();
        CookUtil.pizzaPepperoni();
        Check.add(PIZZA_ORDER_VIEW.orderPizzaPepperoni());
        ORDER_LIST.add(ORDER.add(Pizza.PEPPERONI.name(),
                RoundUtil.up(PizzaPriceUtil.pricePizzaPepperoniIncludingVAT()),
                DateFormatUtil.localDatePattern(LocalDateTime.now())));
        PIZZA_ORDER.add(PizzaPriceUtil.pricePizzaPepperoniIncludingVAT());
        DisplayOrderInfoUtil.showOrderInfo();
        PIZZA_ORDER_VIEW.addSupplementIngredients();
        ChoiceUtil.addChoiceQuestion();
    }

    public static void orderVegetarian() {
        PIZZA_ORDER_VIEW.orderPizzaVegetarian();
        CookUtil.pizzaVegetarian();
        Check.add(PIZZA_ORDER_VIEW.orderPizzaVegetarian());
        ORDER_LIST.add(ORDER.add(Pizza.VEGETARIAN.name(),
                RoundUtil.up(PizzaPriceUtil.pricePizzaVegetarianIncludingVAT()),
                DateFormatUtil.localDatePattern(LocalDateTime.now())));
        PIZZA_ORDER.add(PizzaPriceUtil.pricePizzaVegetarianIncludingVAT());
        DisplayOrderInfoUtil.showOrderInfo();
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
