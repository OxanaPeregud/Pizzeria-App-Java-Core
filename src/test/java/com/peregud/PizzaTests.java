package com.peregud;

import com.peregud.pizza.model.Ingredient;
import com.peregud.pizza.model.Pizza;
import com.peregud.pizza.model.Supplier;
import com.peregud.pizza.util.SoldPizzasUtil;
import com.peregud.pizza.repository.StorageRepository;
import com.peregud.pizza.util.CookUtil;
import com.peregud.pizza.service.OrderCalculatorService;
import com.peregud.pizza.service.OrderStatisticsService;
import com.peregud.pizza.util.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PizzaTests {
    private static final OrderStatisticsService ORDER_STATISTICS;
    private static final StorageRepository STORAGE;
    private static final OrderCalculatorService ORDER;

    static {
        ORDER_STATISTICS = new OrderStatisticsService();
        STORAGE = new StorageRepository();
        ORDER = new OrderCalculatorService(new ArrayList<>());
    }

    @Test
    public void getCostPerUnit_Cheese_Ingredient() {
        assertEquals(2.5, Ingredient.CHEESE.getCostPerUnit());
    }

    @Test
    public void getCostPerUnit_Crust_Ingredient() {
        assertEquals(2, Ingredient.CRUST.getCostPerUnit());
    }

    @Test
    public void getCostPerUnit_Meat_Ingredient() {
        assertEquals(5.2, Ingredient.MEAT.getCostPerUnit());
    }

    @Test
    public void getCostPerUnit_Olives_Ingredient() {
        assertEquals(2.5, Ingredient.OLIVES.getCostPerUnit());
    }

    @Test
    public void getCostPerUnit_Oregano_Ingredient() {
        assertEquals(1.1, Ingredient.OREGANO.getCostPerUnit());
    }

    @Test
    public void getCostPerUnit_Pepper_Ingredient() {
        assertEquals(1.8, Ingredient.PEPPER.getCostPerUnit());
    }

    @Test
    public void getCostPerUnit_Sauce_Ingredient() {
        assertEquals(1, Ingredient.SAUCE.getCostPerUnit());
    }

    @Test
    public void getCostPerUnit_Sausages_Ingredient() {
        assertEquals(6, Ingredient.SAUSAGES.getCostPerUnit());
    }

    @Test
    public void getCostPerUnit_ThinDough_Ingredient() {
        assertEquals(1.9, Ingredient.THIN_DOUGH.getCostPerUnit());
    }

    @Test
    public void getCostPerUnit_Tomatoes_Ingredient() {
        assertEquals(1.5, Ingredient.TOMATOES.getCostPerUnit());
    }

    @Test
    public void getCostPerUnit_TraditionalDough_Ingredient() {
        assertEquals(2.5, Ingredient.TRADITIONAL_DOUGH.getCostPerUnit());
    }

    @Test
    public void getCalories_Cheese_Ingredient() {
        assertEquals(360, Ingredient.CHEESE.getCalories());
    }

    @Test
    public void getCalories_Crust_Ingredient() {
        assertEquals(400, Ingredient.CRUST.getCalories());
    }

    @Test
    public void getCalories_Meat_Ingredient() {
        assertEquals(220, Ingredient.MEAT.getCalories());
    }

    @Test
    public void getCalories_Olives_Ingredient() {
        assertEquals(115, Ingredient.OLIVES.getCalories());
    }

    @Test
    public void getCalories_Oregano_Ingredient() {
        assertEquals(10, Ingredient.OREGANO.getCalories());
    }

    @Test
    public void getCalories_Pepper_Ingredient() {
        assertEquals(30, Ingredient.PEPPER.getCalories());
    }

    @Test
    public void getCalories_Sauce_Ingredient() {
        assertEquals(50, Ingredient.SAUCE.getCalories());
    }

    @Test
    public void getCalories_Sausages_Ingredient() {
        assertEquals(320, Ingredient.SAUSAGES.getCalories());
    }

    @Test
    public void getCalories_ThinDough_Ingredient() {
        assertEquals(150, Ingredient.THIN_DOUGH.getCalories());
    }

    @Test
    public void getCalories_Tomatoes_Ingredient() {
        assertEquals(20, Ingredient.TOMATOES.getCalories());
    }

    @Test
    public void getIngredients_FourCheese_Pizza() {
        assertEquals(Map.of(
                Ingredient.TRADITIONAL_DOUGH, 1,
                Ingredient.SAUCE, 1,
                Ingredient.CHEESE, 4,
                Ingredient.OREGANO, 1),
                Pizza.FOUR_CHEESE.getIngredients());
    }

    @Test
    public void getIngredients_Margherita_Pizza() {
        assertEquals(Map.of(
                Ingredient.TRADITIONAL_DOUGH, 1,
                Ingredient.SAUCE, 1,
                Ingredient.CHEESE, 2,
                Ingredient.TOMATOES, 2,
                Ingredient.OREGANO, 1),
                Pizza.MARGHERITA.getIngredients());
    }

    @Test
    public void getIngredients_MeatDelight_Pizza() {
        assertEquals(Map.of(
                Ingredient.TRADITIONAL_DOUGH, 1,
                Ingredient.SAUCE, 1,
                Ingredient.CHEESE, 1,
                Ingredient.MEAT, 2,
                Ingredient.SAUSAGES, 2),
                Pizza.MEAT_DELIGHT.getIngredients());
    }

    @Test
    public void getIngredients_Pepperoni_Pizza() {
        assertEquals(Map.of(
                Ingredient.TRADITIONAL_DOUGH, 1,
                Ingredient.SAUCE, 1,
                Ingredient.CHEESE, 1,
                Ingredient.MEAT, 3),
                Pizza.PEPPERONI.getIngredients());
    }

    @Test
    public void getIngredients_Vegetarian_Pizza() {
        assertEquals(Map.of(
                Ingredient.TRADITIONAL_DOUGH, 1,
                Ingredient.SAUCE, 1,
                Ingredient.CHEESE, 1,
                Ingredient.TOMATOES, 2,
                Ingredient.PEPPER, 2,
                Ingredient.OLIVES, 2),
                Pizza.VEGETARIAN.getIngredients());
    }

    @Test
    public void getIngredientQuantity_TraditionalDough_FourCheese_Pizza() {
        assertEquals(1, Pizza.FOUR_CHEESE.getIngredientQuantity(Ingredient.TRADITIONAL_DOUGH));
    }

    @Test
    public void getIngredientQuantity_Sauce_FourCheese_Pizza() {
        assertEquals(1, Pizza.FOUR_CHEESE.getIngredientQuantity(Ingredient.SAUCE));
    }

    @Test
    public void getIngredientQuantity_Cheese_FourCheese_Pizza() {
        assertEquals(4, Pizza.FOUR_CHEESE.getIngredientQuantity(Ingredient.CHEESE));
    }

    @Test
    public void getIngredientQuantity_Oregano_FourCheese_Pizza() {
        assertEquals(1, Pizza.FOUR_CHEESE.getIngredientQuantity(Ingredient.OREGANO));
    }

    @Test
    public void getIngredientQuantity_TraditionalDough_Margherita_Pizza() {
        assertEquals(1, Pizza.MARGHERITA.getIngredientQuantity(Ingredient.TRADITIONAL_DOUGH));
    }

    @Test
    public void getIngredientQuantity_Sauce_Margherita_Pizza() {
        assertEquals(1, Pizza.MARGHERITA.getIngredientQuantity(Ingredient.SAUCE));
    }

    @Test
    public void getIngredientQuantity_Cheese_Margherita_Pizza() {
        assertEquals(2, Pizza.MARGHERITA.getIngredientQuantity(Ingredient.CHEESE));
    }

    @Test
    public void getIngredientQuantity_Tomatoes_Margherita_Pizza() {
        assertEquals(2, Pizza.MARGHERITA.getIngredientQuantity(Ingredient.TOMATOES));
    }

    @Test
    public void getIngredientQuantity_Oregano_Margherita_Pizza() {
        assertEquals(1, Pizza.FOUR_CHEESE.getIngredientQuantity(Ingredient.OREGANO));
    }

    @Test
    public void getIngredientQuantity_TraditionalDough_MeatDelight_Pizza() {
        assertEquals(1, Pizza.MEAT_DELIGHT.getIngredientQuantity(Ingredient.TRADITIONAL_DOUGH));
    }

    @Test
    public void getIngredientQuantity_Sauce_MeatDelight_Pizza() {
        assertEquals(1, Pizza.MEAT_DELIGHT.getIngredientQuantity(Ingredient.SAUCE));
    }

    @Test
    public void getIngredientQuantity_Cheese_MeatDelight_Pizza() {
        assertEquals(1, Pizza.MEAT_DELIGHT.getIngredientQuantity(Ingredient.CHEESE));
    }

    @Test
    public void getIngredientQuantity_Meat_MeatDelight_Pizza() {
        assertEquals(2, Pizza.MEAT_DELIGHT.getIngredientQuantity(Ingredient.MEAT));
    }

    @Test
    public void getIngredientQuantity_Sausages_MeatDelight_Pizza() {
        assertEquals(2, Pizza.MEAT_DELIGHT.getIngredientQuantity(Ingredient.SAUSAGES));
    }

    @Test
    public void getIngredientQuantity_TraditionalDough_Pepperoni_Pizza() {
        assertEquals(1, Pizza.PEPPERONI.getIngredientQuantity(Ingredient.TRADITIONAL_DOUGH));
    }

    @Test
    public void getIngredientQuantity_Sauce_Pepperoni_Pizza() {
        assertEquals(1, Pizza.PEPPERONI.getIngredientQuantity(Ingredient.SAUCE));
    }

    @Test
    public void getIngredientQuantity_Cheese_Pepperoni_Pizza() {
        assertEquals(1, Pizza.PEPPERONI.getIngredientQuantity(Ingredient.CHEESE));
    }

    @Test
    public void getIngredientQuantity_Meat_Pepperoni_Pizza() {
        assertEquals(3, Pizza.PEPPERONI.getIngredientQuantity(Ingredient.MEAT));
    }

    @Test
    public void getIngredientQuantity_TraditionalDough_Vegetarian_Pizza() {
        assertEquals(1, Pizza.VEGETARIAN.getIngredientQuantity(Ingredient.TRADITIONAL_DOUGH));
    }

    @Test
    public void getIngredientQuantity_Sauce_Vegetarian_Pizza() {
        assertEquals(1, Pizza.VEGETARIAN.getIngredientQuantity(Ingredient.SAUCE));
    }

    @Test
    public void getIngredientQuantity_Cheese_Vegetarian_Pizza() {
        assertEquals(1, Pizza.VEGETARIAN.getIngredientQuantity(Ingredient.CHEESE));
    }

    @Test
    public void getIngredientQuantity_Tomatoes_Vegetarian_Pizza() {
        assertEquals(2, Pizza.VEGETARIAN.getIngredientQuantity(Ingredient.TOMATOES));
    }

    @Test
    public void getIngredientQuantity_Pepper_Vegetarian_Pizza() {
        assertEquals(2, Pizza.VEGETARIAN.getIngredientQuantity(Ingredient.PEPPER));
    }

    @Test
    public void getIngredientQuantity_Olives_Vegetarian_Pizza() {
        assertEquals(2, Pizza.VEGETARIAN.getIngredientQuantity(Ingredient.OLIVES));
    }

    @Test
    public void getIngredient_Supplier1_Supplier() {
        assertEquals(Ingredient.CHEESE, Supplier.SUPPLIER_1.getIngredient());
    }

    @Test
    public void getIngredient_Supplier2_Supplier() {
        assertEquals(Ingredient.MEAT, Supplier.SUPPLIER_2.getIngredient());
    }

    @Test
    public void getIngredient_Supplier3_Supplier() {
        assertEquals(Ingredient.OLIVES, Supplier.SUPPLIER_3.getIngredient());
    }

    @Test
    public void getIngredient_Supplier4_Supplier() {
        assertEquals(Ingredient.OREGANO, Supplier.SUPPLIER_4.getIngredient());
    }

    @Test
    public void getIngredient_Supplier5_Supplier() {
        assertEquals(Ingredient.PEPPER, Supplier.SUPPLIER_5.getIngredient());
    }

    @Test
    public void getIngredient_Supplier6_Supplier() {
        assertEquals(Ingredient.SAUCE, Supplier.SUPPLIER_6.getIngredient());
    }

    @Test
    public void getIngredient_Supplier7_Supplier() {
        assertEquals(Ingredient.SAUSAGES, Supplier.SUPPLIER_7.getIngredient());
    }

    @Test
    public void getIngredient_Supplier8_Supplier() {
        assertEquals(Ingredient.TOMATOES, Supplier.SUPPLIER_8.getIngredient());
    }

    @Test
    public void countTotalCalories_IngredientCaloriesRepository() {
        IngredientCaloriesCalculatorUtil.add(100);
        IngredientCaloriesCalculatorUtil.add(200);
        IngredientCaloriesCalculatorUtil.add(300);
        assertEquals(600, IngredientCaloriesCalculatorUtil.countTotalCalories());
    }

    @Test
    public void totalOrder_OrderRepository() {
        ORDER.add(100);
        ORDER.add(150);
        ORDER.add(200);
        assertEquals(450, ORDER.totalOrder());
    }

    @Test
    public void size_OrderRepository() {
        assertEquals(3, ORDER.size());
    }

    public void putToStorage() {
        STORAGE.put(Ingredient.CHEESE, 10);
        STORAGE.put(Ingredient.MEAT, 15);
        STORAGE.put(Ingredient.OLIVES, 5);
        STORAGE.put(Ingredient.OREGANO, 11);
        STORAGE.put(Ingredient.PEPPER, 14);
        STORAGE.put(Ingredient.SAUCE, 19);
        STORAGE.put(Ingredient.SAUSAGES, 8);
        STORAGE.put(Ingredient.TOMATOES, 10);
        STORAGE.put(Ingredient.THIN_DOUGH, 11);
        STORAGE.put(Ingredient.TRADITIONAL_DOUGH, 5);
    }

    @Test
    public void getStorage_StorageRepository() {
        putToStorage();
        assertEquals(Map.of(
                Ingredient.SAUSAGES, 8,
                Ingredient.CHEESE, 10,
                Ingredient.PEPPER, 14,
                Ingredient.TRADITIONAL_DOUGH, 5,
                Ingredient.OLIVES, 5,
                Ingredient.THIN_DOUGH, 11,
                Ingredient.MEAT, 15,
                Ingredient.OREGANO, 11,
                Ingredient.SAUCE, 19,
                Ingredient.TOMATOES, 10), STORAGE.getStorage());
    }

    @Test
    public void getIngredientQuantity_Cheese_StorageRepository() {
        putToStorage();
        assertEquals(10, STORAGE.getIngredientQuantity(Ingredient.CHEESE));
    }

    @Test
    public void getIngredientQuantity_Meat_StorageRepository() {
        putToStorage();
        assertEquals(15, STORAGE.getIngredientQuantity(Ingredient.MEAT));
    }

    @Test
    public void getIngredientQuantity_Olives_StorageRepository() {
        putToStorage();
        assertEquals(5, STORAGE.getIngredientQuantity(Ingredient.OLIVES));
    }

    @Test
    public void getIngredientQuantity_Oregano_StorageRepository() {
        putToStorage();
        assertEquals(11, STORAGE.getIngredientQuantity(Ingredient.OREGANO));
    }

    @Test
    public void getIngredientQuantity_Pepper_StorageRepository() {
        putToStorage();
        assertEquals(14, STORAGE.getIngredientQuantity(Ingredient.PEPPER));
    }

    @Test
    public void getIngredientQuantity_Sauce_StorageRepository() {
        putToStorage();
        assertEquals(19, STORAGE.getIngredientQuantity(Ingredient.SAUCE));
    }

    @Test
    public void getIngredientQuantity_Sausages_StorageRepository() {
        putToStorage();
        assertEquals(8, STORAGE.getIngredientQuantity(Ingredient.SAUSAGES));
    }

    @Test
    public void getIngredientQuantity_Tomatoes_StorageRepository() {
        putToStorage();
        assertEquals(10, STORAGE.getIngredientQuantity(Ingredient.TOMATOES));
    }

    @Test
    public void getIngredientQuantity_ThinDough_StorageRepository() {
        putToStorage();
        assertEquals(11, STORAGE.getIngredientQuantity(Ingredient.THIN_DOUGH));
    }

    @Test
    public void getIngredientQuantity_TraditionalDough_StorageRepository() {
        putToStorage();
        assertEquals(5, STORAGE.getIngredientQuantity(Ingredient.TRADITIONAL_DOUGH));
    }

    @Test
    public void changeIngredientQuantity_FourCheese_StorageRepository() {
        putToStorage();
        STORAGE.changeIngredientQuantity(Pizza.FOUR_CHEESE);
        assertEquals(Map.of(
                Ingredient.SAUSAGES, 8,
                Ingredient.CHEESE, 6,
                Ingredient.PEPPER, 14,
                Ingredient.TRADITIONAL_DOUGH, 4,
                Ingredient.OLIVES, 5,
                Ingredient.THIN_DOUGH, 11,
                Ingredient.MEAT, 15,
                Ingredient.OREGANO, 10,
                Ingredient.SAUCE, 18,
                Ingredient.TOMATOES, 10), STORAGE.getStorage());
    }

    @Test
    public void changeIngredientQuantity_Margherita_StorageRepository() {
        putToStorage();
        STORAGE.changeIngredientQuantity(Pizza.MARGHERITA);
        assertEquals(Map.of(
                Ingredient.SAUSAGES, 8,
                Ingredient.CHEESE, 8,
                Ingredient.PEPPER, 14,
                Ingredient.TRADITIONAL_DOUGH, 4,
                Ingredient.OLIVES, 5,
                Ingredient.THIN_DOUGH, 11,
                Ingredient.MEAT, 15,
                Ingredient.OREGANO, 10,
                Ingredient.SAUCE, 18,
                Ingredient.TOMATOES, 8), STORAGE.getStorage());
    }

    @Test
    public void changeIngredientQuantity_MeatDelight_StorageRepository() {
        putToStorage();
        STORAGE.changeIngredientQuantity(Pizza.MEAT_DELIGHT);
        assertEquals(Map.of(
                Ingredient.SAUSAGES, 6,
                Ingredient.CHEESE, 9,
                Ingredient.PEPPER, 14,
                Ingredient.TRADITIONAL_DOUGH, 4,
                Ingredient.OLIVES, 5,
                Ingredient.THIN_DOUGH, 11,
                Ingredient.MEAT, 13,
                Ingredient.OREGANO, 11,
                Ingredient.SAUCE, 18,
                Ingredient.TOMATOES, 10), STORAGE.getStorage());
    }

    @Test
    public void changeIngredientQuantity_Pepperoni_StorageRepository() {
        putToStorage();
        STORAGE.changeIngredientQuantity(Pizza.PEPPERONI);
        assertEquals(Map.of(
                Ingredient.SAUSAGES, 8,
                Ingredient.CHEESE, 9,
                Ingredient.PEPPER, 14,
                Ingredient.TRADITIONAL_DOUGH, 4,
                Ingredient.OLIVES, 5,
                Ingredient.THIN_DOUGH, 11,
                Ingredient.MEAT, 12,
                Ingredient.OREGANO, 11,
                Ingredient.SAUCE, 18,
                Ingredient.TOMATOES, 10), STORAGE.getStorage());
    }

    @Test
    public void changeIngredientQuantity_Vegetarian_StorageRepository() {
        putToStorage();
        STORAGE.changeIngredientQuantity(Pizza.VEGETARIAN);
        assertEquals(Map.of(
                Ingredient.SAUSAGES, 8,
                Ingredient.CHEESE, 9,
                Ingredient.PEPPER, 12,
                Ingredient.TRADITIONAL_DOUGH, 4,
                Ingredient.OLIVES, 3,
                Ingredient.THIN_DOUGH, 11,
                Ingredient.MEAT, 15,
                Ingredient.OREGANO, 11,
                Ingredient.SAUCE, 18,
                Ingredient.TOMATOES, 8), STORAGE.getStorage());
    }

    @Test
    public void changeIngredientQuantity_Cheese_StorageRepository() {
        STORAGE.changeIngredientQuantity(Ingredient.CHEESE, 10);
        assertEquals(10, STORAGE.getIngredientQuantity(Ingredient.CHEESE));
    }

    @Test
    public void changeIngredientQuantity_Meat_StorageRepository() {
        STORAGE.changeIngredientQuantity(Ingredient.MEAT, 11);
        assertEquals(11, STORAGE.getIngredientQuantity(Ingredient.MEAT));
    }

    @Test
    public void changeIngredientQuantity_Olives_StorageRepository() {
        STORAGE.changeIngredientQuantity(Ingredient.OLIVES, 1);
        assertEquals(1, STORAGE.getIngredientQuantity(Ingredient.OLIVES));
    }

    @Test
    public void changeIngredientQuantity_Oregano_StorageRepository() {
        STORAGE.changeIngredientQuantity(Ingredient.OREGANO, 35);
        assertEquals(35, STORAGE.getIngredientQuantity(Ingredient.OREGANO));
    }

    @Test
    public void changeIngredientQuantity_Pepper_StorageRepository() {
        STORAGE.changeIngredientQuantity(Ingredient.PEPPER, 50);
        assertEquals(50, STORAGE.getIngredientQuantity(Ingredient.PEPPER));
    }

    @Test
    public void changeIngredientQuantity_Sauce_StorageRepository() {
        STORAGE.changeIngredientQuantity(Ingredient.SAUCE, 70);
        assertEquals(70, STORAGE.getIngredientQuantity(Ingredient.SAUCE));
    }

    @Test
    public void changeIngredientQuantity_Sausages_StorageRepository() {
        STORAGE.changeIngredientQuantity(Ingredient.SAUSAGES, 2);
        assertEquals(2, STORAGE.getIngredientQuantity(Ingredient.SAUSAGES));
    }

    @Test
    public void changeIngredientQuantity_Tomatoes_StorageRepository() {
        STORAGE.changeIngredientQuantity(Ingredient.TOMATOES, 12);
        assertEquals(12, STORAGE.getIngredientQuantity(Ingredient.TOMATOES));
    }

    @Test
    public void changeIngredientQuantity_ThinDough_StorageRepository() {
        STORAGE.changeIngredientQuantity(Ingredient.THIN_DOUGH, 30);
        assertEquals(30, STORAGE.getIngredientQuantity(Ingredient.THIN_DOUGH));
    }

    @Test
    public void changeIngredientQuantity_TraditionalDough_StorageRepository() {
        STORAGE.changeIngredientQuantity(Ingredient.TRADITIONAL_DOUGH, 3);
        assertEquals(3, STORAGE.getIngredientQuantity(Ingredient.TRADITIONAL_DOUGH));
    }

    @Test
    public void removeOneIngredient_Cheese_StorageRepository() {
        putToStorage();
        STORAGE.removeOneIngredient(Ingredient.CHEESE);
        assertEquals(9, STORAGE.getIngredientQuantity(Ingredient.CHEESE));
    }

    @Test
    public void removeOneIngredient_Meat_StorageRepository() {
        putToStorage();
        STORAGE.removeOneIngredient(Ingredient.MEAT);
        assertEquals(14, STORAGE.getIngredientQuantity(Ingredient.MEAT));
    }

    @Test
    public void removeOneIngredient_Olives_StorageRepository() {
        putToStorage();
        STORAGE.removeOneIngredient(Ingredient.OLIVES);
        assertEquals(4, STORAGE.getIngredientQuantity(Ingredient.OLIVES));
    }

    @Test
    public void removeOneIngredient_Oregano_StorageRepository() {
        putToStorage();
        STORAGE.removeOneIngredient(Ingredient.OREGANO);
        assertEquals(10, STORAGE.getIngredientQuantity(Ingredient.OREGANO));
    }

    @Test
    public void removeOneIngredient_Pepper_StorageRepository() {
        putToStorage();
        STORAGE.removeOneIngredient(Ingredient.PEPPER);
        assertEquals(13, STORAGE.getIngredientQuantity(Ingredient.PEPPER));
    }

    @Test
    public void removeOneIngredient_Sauce_StorageRepository() {
        putToStorage();
        STORAGE.removeOneIngredient(Ingredient.SAUCE);
        assertEquals(18, STORAGE.getIngredientQuantity(Ingredient.SAUCE));
    }

    @Test
    public void removeOneIngredient_Sausages_StorageRepository() {
        putToStorage();
        STORAGE.removeOneIngredient(Ingredient.SAUSAGES);
        assertEquals(7, STORAGE.getIngredientQuantity(Ingredient.SAUSAGES));
    }

    @Test
    public void removeOneIngredient_Tomatoes_StorageRepository() {
        putToStorage();
        STORAGE.removeOneIngredient(Ingredient.TOMATOES);
        assertEquals(9, STORAGE.getIngredientQuantity(Ingredient.TOMATOES));
    }

    @Test
    public void removeOneIngredient_ThinDough_StorageRepository() {
        putToStorage();
        STORAGE.removeOneIngredient(Ingredient.THIN_DOUGH);
        assertEquals(10, STORAGE.getIngredientQuantity(Ingredient.THIN_DOUGH));
    }

    @Test
    public void removeOneIngredient_TraditionalDough_StorageRepository() {
        putToStorage();
        STORAGE.removeOneIngredient(Ingredient.TRADITIONAL_DOUGH);
        assertEquals(4, STORAGE.getIngredientQuantity(Ingredient.TRADITIONAL_DOUGH));
    }

    @Test
    public void getCalories_TraditionalDough_Ingredient() {
        assertEquals(250, Ingredient.TRADITIONAL_DOUGH.getCalories());
    }

    @Test
    public void countChange_CashPaymentService() {
        CashPaymentUtil.fullAmount = 250;
        assertEquals(150, CashPaymentUtil.countChange(100));
    }

    @Test
    public void pizzaFourCheese_TraditionalDough_CookService() {
        int oldQuantity = STORAGE.getIngredientQuantity(Ingredient.TRADITIONAL_DOUGH);
        CookUtil.cookPizza(Pizza.FOUR_CHEESE);
        assertEquals(oldQuantity - 1, STORAGE.getIngredientQuantity(Ingredient.TRADITIONAL_DOUGH));
    }

    @Test
    public void pizzaFourCheese_Sauce_CookService() {
        int oldQuantity = STORAGE.getIngredientQuantity(Ingredient.SAUCE);
        CookUtil.cookPizza(Pizza.FOUR_CHEESE);
        assertEquals(oldQuantity - 1, STORAGE.getIngredientQuantity(Ingredient.SAUCE));
    }

    @Test
    public void pizzaFourCheese_Cheese_CookService() {
        int oldQuantity = STORAGE.getIngredientQuantity(Ingredient.CHEESE);
        CookUtil.cookPizza(Pizza.FOUR_CHEESE);
        assertEquals(oldQuantity - 4, STORAGE.getIngredientQuantity(Ingredient.CHEESE));
    }

    @Test
    public void pizzaFourCheese_Oregano_CookService() {
        int oldQuantity = STORAGE.getIngredientQuantity(Ingredient.OREGANO);
        CookUtil.cookPizza(Pizza.FOUR_CHEESE);
        assertEquals(oldQuantity - 1, STORAGE.getIngredientQuantity(Ingredient.OREGANO));
    }

    @Test
    public void pizzaMargherita_TraditionalDough_CookService() {
        int oldQuantity = STORAGE.getIngredientQuantity(Ingredient.TRADITIONAL_DOUGH);
        CookUtil.cookPizza(Pizza.MARGHERITA);
        assertEquals(oldQuantity - 1, STORAGE.getIngredientQuantity(Ingredient.TRADITIONAL_DOUGH));
    }

    @Test
    public void pizzaMargherita_Sauce_CookService() {
        int oldQuantity = STORAGE.getIngredientQuantity(Ingredient.SAUCE);
        CookUtil.cookPizza(Pizza.MARGHERITA);
        assertEquals(oldQuantity - 1, STORAGE.getIngredientQuantity(Ingredient.SAUCE));
    }

    @Test
    public void pizzaMargherita_Cheese_CookService() {
        int oldQuantity = STORAGE.getIngredientQuantity(Ingredient.CHEESE);
        CookUtil.cookPizza(Pizza.MARGHERITA);
        assertEquals(oldQuantity - 2, STORAGE.getIngredientQuantity(Ingredient.CHEESE));
    }

    @Test
    public void pizzaMargherita_Tomatoes_CookService() {
        int oldQuantity = STORAGE.getIngredientQuantity(Ingredient.TOMATOES);
        CookUtil.cookPizza(Pizza.MARGHERITA);
        assertEquals(oldQuantity - 2, STORAGE.getIngredientQuantity(Ingredient.TOMATOES));
    }

    @Test
    public void pizzaMargherita_Oregano_CookService() {
        int oldQuantityOregano = STORAGE.getIngredientQuantity(Ingredient.OREGANO);
        CookUtil.cookPizza(Pizza.MARGHERITA);
        assertEquals(oldQuantityOregano - 1, STORAGE.getIngredientQuantity(Ingredient.OREGANO));
    }

    @Test
    public void pizzaMeatDelight_TraditionalDough_CookService() {
        int oldQuantity = STORAGE.getIngredientQuantity(Ingredient.TRADITIONAL_DOUGH);
        CookUtil.cookPizza(Pizza.MEAT_DELIGHT);
        assertEquals(oldQuantity - 1, STORAGE.getIngredientQuantity(Ingredient.TRADITIONAL_DOUGH));
    }

    @Test
    public void pizzaMeatDelight_Sauce_CookService() {
        int oldQuantity = STORAGE.getIngredientQuantity(Ingredient.SAUCE);
        CookUtil.cookPizza(Pizza.MEAT_DELIGHT);
        assertEquals(oldQuantity - 1, STORAGE.getIngredientQuantity(Ingredient.SAUCE));
    }

    @Test
    public void pizzaMeatDelight_Cheese_CookService() {
        int oldQuantity = STORAGE.getIngredientQuantity(Ingredient.CHEESE);
        CookUtil.cookPizza(Pizza.MEAT_DELIGHT);
        assertEquals(oldQuantity - 1, STORAGE.getIngredientQuantity(Ingredient.CHEESE));
    }

    @Test
    public void pizzaMeatDelight_Meat_CookService() {
        int oldQuantity = STORAGE.getIngredientQuantity(Ingredient.MEAT);
        CookUtil.cookPizza(Pizza.MEAT_DELIGHT);
        assertEquals(oldQuantity - 2, STORAGE.getIngredientQuantity(Ingredient.MEAT));
    }

    @Test
    public void pizzaMeatDelight_Sausages_CookService() {
        int oldQuantity = STORAGE.getIngredientQuantity(Ingredient.SAUSAGES);
        CookUtil.cookPizza(Pizza.MEAT_DELIGHT);
        assertEquals(oldQuantity - 2, STORAGE.getIngredientQuantity(Ingredient.SAUSAGES));
    }

    @Test
    public void pizzaPepperoni_TraditionalDough_CookService() {
        int oldQuantity = STORAGE.getIngredientQuantity(Ingredient.TRADITIONAL_DOUGH);
        CookUtil.cookPizza(Pizza.PEPPERONI);
        assertEquals(oldQuantity - 1, STORAGE.getIngredientQuantity(Ingredient.TRADITIONAL_DOUGH));
    }

    @Test
    public void pizzaPepperoni_Sauce_CookService() {
        int oldQuantity = STORAGE.getIngredientQuantity(Ingredient.SAUCE);
        CookUtil.cookPizza(Pizza.PEPPERONI);
        assertEquals(oldQuantity - 1, STORAGE.getIngredientQuantity(Ingredient.SAUCE));
    }

    @Test
    public void pizzaPepperoni_Cheese_CookService() {
        int oldQuantity = STORAGE.getIngredientQuantity(Ingredient.CHEESE);
        CookUtil.cookPizza(Pizza.PEPPERONI);
        assertEquals(oldQuantity - 1, STORAGE.getIngredientQuantity(Ingredient.CHEESE));
    }

    @Test
    public void pizzaPepperoni_Meat_CookService() {
        int oldQuantity = STORAGE.getIngredientQuantity(Ingredient.MEAT);
        CookUtil.cookPizza(Pizza.PEPPERONI);
        assertEquals(oldQuantity - 3, STORAGE.getIngredientQuantity(Ingredient.MEAT));
    }

    @Test
    public void pizzaVegetarian_TraditionalDough_CookService() {
        int oldQuantity = STORAGE.getIngredientQuantity(Ingredient.TRADITIONAL_DOUGH);
        CookUtil.cookPizza(Pizza.VEGETARIAN);
        assertEquals(oldQuantity - 1, STORAGE.getIngredientQuantity(Ingredient.TRADITIONAL_DOUGH));
    }

    @Test
    public void pizzaVegetarian_Sauce_CookService() {
        int oldQuantity = STORAGE.getIngredientQuantity(Ingredient.SAUCE);
        CookUtil.cookPizza(Pizza.VEGETARIAN);
        assertEquals(oldQuantity - 1, STORAGE.getIngredientQuantity(Ingredient.SAUCE));
    }

    @Test
    public void pizzaVegetarian_Cheese_CookService() {
        int oldQuantity = STORAGE.getIngredientQuantity(Ingredient.CHEESE);
        CookUtil.cookPizza(Pizza.VEGETARIAN);
        assertEquals(oldQuantity - 1, STORAGE.getIngredientQuantity(Ingredient.CHEESE));
    }

    @Test
    public void pizzaVegetarian_Tomatoes_CookService() {
        int oldQuantity = STORAGE.getIngredientQuantity(Ingredient.TOMATOES);
        CookUtil.cookPizza(Pizza.VEGETARIAN);
        assertEquals(oldQuantity - 2, STORAGE.getIngredientQuantity(Ingredient.TOMATOES));
    }

    @Test
    public void pizzaVegetarian_Pepper_CookService() {
        int oldQuantity = STORAGE.getIngredientQuantity(Ingredient.PEPPER);
        CookUtil.cookPizza(Pizza.VEGETARIAN);
        assertEquals(oldQuantity - 2, STORAGE.getIngredientQuantity(Ingredient.PEPPER));
    }

    @Test
    public void pizzaVegetarian_Olives_CookService() {
        int oldQuantity = STORAGE.getIngredientQuantity(Ingredient.OLIVES);
        CookUtil.cookPizza(Pizza.VEGETARIAN);
        assertEquals(oldQuantity - 2, STORAGE.getIngredientQuantity(Ingredient.OLIVES));
    }

    @Test
    public void thinDough_CookService() {
        int oldQuantity = STORAGE.getIngredientQuantity(Ingredient.THIN_DOUGH);
        CookUtil.cookIngredient(Ingredient.THIN_DOUGH);
        assertEquals(oldQuantity - 1, STORAGE.getIngredientQuantity(Ingredient.THIN_DOUGH));
    }

    @Test
    public void traditionalDough_CookService() {
        int oldQuantity = STORAGE.getIngredientQuantity(Ingredient.TRADITIONAL_DOUGH);
        CookUtil.cookIngredient(Ingredient.TRADITIONAL_DOUGH);
        assertEquals(oldQuantity - 1, STORAGE.getIngredientQuantity(Ingredient.TRADITIONAL_DOUGH));
    }

    @Test
    public void cheese_CookService() {
        int oldQuantity = STORAGE.getIngredientQuantity(Ingredient.CHEESE);
        CookUtil.cookIngredient(Ingredient.CHEESE);
        assertEquals(oldQuantity - 1, STORAGE.getIngredientQuantity(Ingredient.CHEESE));
    }

    @Test
    public void meat_CookService() {
        int oldQuantity = STORAGE.getIngredientQuantity(Ingredient.MEAT);
        CookUtil.cookIngredient(Ingredient.MEAT);
        assertEquals(oldQuantity - 1, STORAGE.getIngredientQuantity(Ingredient.MEAT));
    }

    @Test
    public void sausages_CookService() {
        int oldQuantity = STORAGE.getIngredientQuantity(Ingredient.SAUSAGES);
        CookUtil.cookIngredient(Ingredient.SAUSAGES);
        assertEquals(oldQuantity - 1, STORAGE.getIngredientQuantity(Ingredient.SAUSAGES));
    }

    @Test
    public void olives_CookService() {
        int oldQuantity = STORAGE.getIngredientQuantity(Ingredient.OLIVES);
        CookUtil.cookIngredient(Ingredient.OLIVES);
        assertEquals(oldQuantity - 1, STORAGE.getIngredientQuantity(Ingredient.OLIVES));
    }

    @Test
    public void tomatoes_CookService() {
        int oldQuantity = STORAGE.getIngredientQuantity(Ingredient.TOMATOES);
        CookUtil.cookIngredient(Ingredient.TOMATOES);
        assertEquals(oldQuantity - 1, STORAGE.getIngredientQuantity(Ingredient.TOMATOES));
    }

    @Test
    public void pepper_CookService() {
        int oldQuantity = STORAGE.getIngredientQuantity(Ingredient.PEPPER);
        CookUtil.cookIngredient(Ingredient.PEPPER);
        assertEquals(oldQuantity - 1, STORAGE.getIngredientQuantity(Ingredient.PEPPER));
    }

    @Test
    public void oregano_CookService() {
        int oldQuantity = STORAGE.getIngredientQuantity(Ingredient.OREGANO);
        CookUtil.cookIngredient(Ingredient.OREGANO);
        assertEquals(oldQuantity - 1, STORAGE.getIngredientQuantity(Ingredient.OREGANO));
    }

    @Test
    public void sauce_CookService() {
        int oldQuantity = STORAGE.getIngredientQuantity(Ingredient.SAUCE);
        CookUtil.cookIngredient(Ingredient.SAUCE);
        assertEquals(oldQuantity - 1, STORAGE.getIngredientQuantity(Ingredient.SAUCE));
    }

    @Test
    public void discountForTwoItems_DiscountService() {
        assertEquals(90, DiscountUtil.discountForTwoItems(100));
    }

    @Test
    public void discountForThreeAndMoreItems_DiscountService() {
        assertEquals(80, DiscountUtil.discountForThreeAndMoreItems(100));
    }

    @Test
    public void discountForOrderOnSpecificDay_DiscountService() {
        assertEquals(85, DiscountUtil.discountForOrderOnSpecificDay(100));
    }

    @Test
    public void amountToPayFor2PizzasOnSpecificDay_DiscountService() {
        assertEquals(75, DiscountUtil.amountToPayFor2PizzasOnSpecificDay(100));
    }

    @Test
    public void amountToPayFor3AndMorePizzasOnSpecificDay_DiscountService() {
        assertEquals(65, DiscountUtil.amountToPayFor3AndMorePizzasOnSpecificDay(100));
    }

    @Test
    public void priceThinDoughWithoutVAT_IngredientPriceService() {
        assertEquals(2.47, RoundUtil.up(IngredientPriceUtil.priceThinDoughWithoutVAT()));
    }

    @Test
    public void priceThinDoughIncludingVAT_IngredientPriceService() {
        assertEquals(2.96, RoundUtil.up(IngredientPriceUtil.priceThinDoughIncludingVAT()));
    }

    @Test
    public void priceTraditionalDoughWithoutVAT_IngredientPriceService() {
        assertEquals(3.25, RoundUtil.up(IngredientPriceUtil.priceTraditionalDoughWithoutVAT()));
    }

    @Test
    public void priceTraditionalDoughIncludingVAT_IngredientPriceService() {
        assertEquals(3.9, RoundUtil.up(IngredientPriceUtil.priceTraditionalDoughIncludingVAT()));
    }

    @Test
    public void priceCheeseWithoutVAT_IngredientPriceService() {
        assertEquals(3.25, RoundUtil.up(IngredientPriceUtil.priceCheeseWithoutVAT()));
    }

    @Test
    public void priceCheeseIncludingVAT_IngredientPriceService() {
        assertEquals(3.9, RoundUtil.up(IngredientPriceUtil.priceCheeseIncludingVAT()));
    }

    @Test
    public void priceMeatWithoutVAT_IngredientPriceService() {
        assertEquals(6.76, RoundUtil.up(IngredientPriceUtil.priceMeatWithoutVAT()));
    }

    @Test
    public void priceMeatIncludingVAT_IngredientPriceService() {
        assertEquals(8.11, RoundUtil.up(IngredientPriceUtil.priceMeatIncludingVAT()));
    }

    @Test
    public void priceSausagesWithoutVAT_IngredientPriceService() {
        assertEquals(7.8, RoundUtil.up(IngredientPriceUtil.priceSausagesWithoutVAT()));
    }

    @Test
    public void priceSausagesIncludingVAT_IngredientPriceService() {
        assertEquals(9.36, RoundUtil.up(IngredientPriceUtil.priceSausagesIncludingVAT()));
    }

    @Test
    public void priceOlivesWithoutVAT_IngredientPriceService() {
        assertEquals(3.25, RoundUtil.up(IngredientPriceUtil.priceOlivesWithoutVAT()));
    }

    @Test
    public void priceOlivesIncludingVAT_IngredientPriceService() {
        assertEquals(3.9, RoundUtil.up(IngredientPriceUtil.priceOlivesIncludingVAT()));
    }

    @Test
    public void priceTomatoesWithoutVAT_IngredientPriceService() {
        assertEquals(1.95, RoundUtil.up(IngredientPriceUtil.priceTomatoesWithoutVAT()));
    }

    @Test
    public void priceTomatoesIncludingVAT_IngredientPriceService() {
        assertEquals(2.34, RoundUtil.up(IngredientPriceUtil.priceTomatoesIncludingVAT()));
    }

    @Test
    public void pricePepperWithoutVAT_IngredientPriceService() {
        assertEquals(2.34, RoundUtil.up(IngredientPriceUtil.pricePepperWithoutVAT()));
    }

    @Test
    public void pricePepperIncludingVAT_IngredientPriceService() {
        assertEquals(2.81, RoundUtil.up(IngredientPriceUtil.pricePepperIncludingVAT()));
    }

    @Test
    public void priceOreganoWithoutVAT_IngredientPriceService() {
        assertEquals(1.43, RoundUtil.up(IngredientPriceUtil.priceOreganoWithoutVAT()));
    }

    @Test
    public void priceOreganoIncludingVAT_IngredientPriceService() {
        assertEquals(1.72, RoundUtil.up(IngredientPriceUtil.priceOreganoIncludingVAT()));
    }

    @Test
    public void priceSauceWithoutVAT_IngredientPriceService() {
        assertEquals(1.3, RoundUtil.up(IngredientPriceUtil.priceSauceWithoutVAT()));
    }

    @Test
    public void priceSauceIncludingVAT_IngredientPriceService() {
        assertEquals(1.56, RoundUtil.up(IngredientPriceUtil.priceSauceIncludingVAT()));
    }

    @Test
    public void priceCrustWithoutVAT_IngredientPriceService() {
        assertEquals(2.6, RoundUtil.up(IngredientPriceUtil.priceCrustWithoutVAT()));
    }

    @Test
    public void priceCrustIncludingVAT_IngredientPriceService() {
        assertEquals(3.12, RoundUtil.up(IngredientPriceUtil.priceCrustIncludingVAT()));
    }

    public void putToMap() {
        SoldPizzasUtil.getSoldPizzas().put(1, 5);
        SoldPizzasUtil.getSoldPizzas().put(2, 5);
        SoldPizzasUtil.getSoldPizzas().put(3, 11);
        SoldPizzasUtil.getSoldPizzas().put(4, 1);
        SoldPizzasUtil.getSoldPizzas().put(5, 20);
    }

    @Test
    public void pizzasSold_OrderStatisticsService() {
        putToMap();
        assertEquals(List.of(5, 5, 11, 1, 20), ORDER_STATISTICS.pizzasSold());
    }

    @Test
    public void totalPizzasSold_OrderStatisticsService() {
        putToMap();
        assertEquals(42, ORDER_STATISTICS.totalPizzasSold());
    }

    @Test
    public void pizzasPrices_OrderStatisticsService() {
        putToMap();
        assertEquals(List.of(PizzaPriceUtil.pricePizzaFourCheeseIncludingVAT(),
                PizzaPriceUtil.pricePizzaMargheritaIncludingVAT(),
                PizzaPriceUtil.pricePizzaMeatDelightIncludingVAT(),
                PizzaPriceUtil.pricePizzaPepperoniIncludingVAT(),
                PizzaPriceUtil.pricePizzaVegetarianIncludingVAT()),
                ORDER_STATISTICS.pizzasPrices());
    }

    @Test
    public void pizzasRevenue_FourCheese_OrderStatisticsService() {
        putToMap();
        assertEquals(RoundUtil.up(5 * PizzaPriceUtil.pricePizzaFourCheeseIncludingVAT()),
                RoundUtil.up(ORDER_STATISTICS.pizzasRevenue().get(0)));
    }

    @Test
    public void pizzasRevenue_Margherita_OrderStatisticsService() {
        putToMap();
        assertEquals(RoundUtil.up(5 * PizzaPriceUtil.pricePizzaMargheritaIncludingVAT()),
                RoundUtil.up(ORDER_STATISTICS.pizzasRevenue().get(1)));
    }

    @Test
    public void pizzasRevenue_MeatDelight_OrderStatisticsService() {
        putToMap();
        assertEquals(RoundUtil.up(11 * PizzaPriceUtil.pricePizzaMeatDelightIncludingVAT()),
                RoundUtil.up(ORDER_STATISTICS.pizzasRevenue().get(2)));
    }

    @Test
    public void pizzasRevenue_Pepperoni_OrderStatisticsService() {
        putToMap();
        assertEquals(RoundUtil.up(1 * PizzaPriceUtil.pricePizzaPepperoniIncludingVAT()),
                RoundUtil.up(ORDER_STATISTICS.pizzasRevenue().get(3)));
    }

    @Test
    public void pizzasRevenue_Vegetarian_OrderStatisticsService() {
        putToMap();
        assertEquals(RoundUtil.up(20 * PizzaPriceUtil.pricePizzaVegetarianIncludingVAT()),
                RoundUtil.up(ORDER_STATISTICS.pizzasRevenue().get(4)));
    }

    @Test
    public void totalRevenue_OrderStatisticsService() {
        putToMap();
        assertEquals(1282.32, ORDER_STATISTICS.totalRevenue());
    }

    @Test
    public void averageCheck_OrderStatisticsService() {
        putToMap();
        assertEquals(30.53, ORDER_STATISTICS.averageCheck());
    }

    @Test
    public void totalCost_OrderStatisticsService() {
        putToMap();
        assertEquals(822.0, ORDER_STATISTICS.totalCost());
    }

    @Test
    public void totalProfit_OrderStatisticsService() {
        putToMap();
        assertEquals(202.21, ORDER_STATISTICS.totalProfit());
    }

    @Test
    public void profitMargin_OrderStatisticsService() {
        putToMap();
        assertEquals(15.77, ORDER_STATISTICS.profitMargin());
    }

    @Test
    public void caloriesPizzaFourCheese_PizzaCaloriesService() {
        assertEquals(1750, PizzaCaloriesUtil.caloriesPizzaFourCheese());
    }

    @Test
    public void caloriesPizzaMargherita_PizzaCaloriesService() {
        assertEquals(1420, PizzaCaloriesUtil.caloriesPizzaMargherita());
    }

    @Test
    public void caloriesPizzaMeatDelight_PizzaCaloriesService() {
        assertEquals(1740, PizzaCaloriesUtil.caloriesPizzaMeatDelight());
    }

    @Test
    public void caloriesPizzaPepperoni_PizzaCaloriesService() {
        assertEquals(1320, PizzaCaloriesUtil.caloriesPizzaPepperoni());
    }

    @Test
    public void caloriesPizzaVegetarian_PizzaCaloriesService() {
        assertEquals(990, PizzaCaloriesUtil.caloriesPizzaVegetarian());
    }

    @Test
    public void costFourCheese_PizzaCostService() {
        assertEquals(14.6, PizzaCostUtil.costFourCheese());
    }

    @Test
    public void costMargherita_PizzaCostService() {
        assertEquals(12.6, PizzaCostUtil.costMargherita());
    }

    @Test
    public void costMeatDelight_PizzaCostService() {
        assertEquals(28.4, PizzaCostUtil.costMeatDelight());
    }

    @Test
    public void costPepperoni_PizzaCostService() {
        assertEquals(21.6, PizzaCostUtil.costPepperoni());
    }

    @Test
    public void costVegetarian_PizzaCostService() {
        assertEquals(17.6, PizzaCostUtil.costVegetarian());
    }

    @Test
    public void pricePizzaFourCheeseWithoutVAT_PizzaPriceService() {
        assertEquals(18.98, RoundUtil.up(PizzaPriceUtil.pricePizzaFourCheeseWithoutVAT()));
    }

    @Test
    public void pricePizzaFourCheeseIncludingVAT_PizzaPriceService() {
        assertEquals(22.78, RoundUtil.up(PizzaPriceUtil.pricePizzaFourCheeseIncludingVAT()));
    }

    @Test
    public void pricePizzaMargheritaWithoutVAT_PizzaPriceService() {
        assertEquals(16.38, RoundUtil.up(PizzaPriceUtil.pricePizzaMargheritaWithoutVAT()));
    }

    @Test
    public void pricePizzaMargheritaIncludingVAT_PizzaPriceService() {
        assertEquals(19.66, RoundUtil.up(PizzaPriceUtil.pricePizzaMargheritaIncludingVAT()));
    }

    @Test
    public void pricePizzaMeatDelightWithoutVAT_PizzaPriceService() {
        assertEquals(36.92, RoundUtil.up(PizzaPriceUtil.pricePizzaMeatDelightWithoutVAT()));
    }

    @Test
    public void pricePizzaMeatDelightIncludingVAT_PizzaPriceService() {
        assertEquals(44.3, RoundUtil.up(PizzaPriceUtil.pricePizzaMeatDelightIncludingVAT()));
    }

    @Test
    public void pricePizzaPepperoniWithoutVAT_PizzaPriceService() {
        assertEquals(28.08, RoundUtil.up(PizzaPriceUtil.pricePizzaPepperoniWithoutVAT()));
    }

    @Test
    public void pricePizzaPepperoniIncludingVAT_PizzaPriceService() {
        assertEquals(33.7, RoundUtil.up(PizzaPriceUtil.pricePizzaPepperoniIncludingVAT()));
    }

    @Test
    public void pricePizzaVegetarianWithoutVAT_PizzaPriceService() {
        assertEquals(22.88, RoundUtil.up(PizzaPriceUtil.pricePizzaVegetarianWithoutVAT()));
    }

    @Test
    public void pricePizzaVegetarianIncludingVAT_PizzaPriceService() {
        assertEquals(27.46, RoundUtil.up(PizzaPriceUtil.pricePizzaVegetarianIncludingVAT()));
    }

    @Test
    public void profitPercentage_ProfitService() {
        assertEquals(130, ProfitUtil.profitPercentage(100));
    }

    @Test
    public void VAT_TaxService() {
        assertEquals(20, TaxUtil.VAT(100));
    }

    @Test
    public void VATonRevenue_TaxService() {
        assertEquals(20, TaxUtil.VATonRevenue(120));
    }

    @Test
    public void CorporateIncomeTax_TaxService() {
        assertEquals(82, TaxUtil.CorporateIncomeTax(100));
    }
}
