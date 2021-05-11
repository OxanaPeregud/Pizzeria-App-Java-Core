/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.util;

import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@UtilityClass
public class OrderStatisticsUtil {

    public List<Integer> soldItems(Map<Integer, Integer> soldItems) {
        return new ArrayList<>(soldItems
                .values());
    }

    public int totalSold(Map<Integer, Integer> soldItems) {
        return soldItems
                .values()
                .stream()
                .mapToInt(Integer::intValue)
                .reduce(0, Integer::sum);
    }

    public List<Double> prices(Map<Integer, Double> prices) {
        return new ArrayList<>(prices
                .values());
    }

    public List<Double> revenue(List<Integer> soldItems, List<Double> prices) {
        List<Double> revenue = new ArrayList<>();
        for (int i = 0; i < soldItems.size(); i++) {
            revenue.add(soldItems.get(i) * prices.get(i));
        }
        return new ArrayList<>(revenue);
    }

    public double totalRevenue(Map<Integer, Integer> soldItems, Map<Integer, Double> prices) {
        double sum = 0;
        for (Integer key : soldItems.keySet()) {
            double value1 = soldItems.get(key);
            double value2 = prices.get(key);
            sum += value1 * value2;
        }
        return RoundUtil.up(sum);
    }

    public double averageCheck(Map<Integer, Integer> soldItems, Map<Integer, Double> prices) {
        return RoundUtil.up(totalRevenue(soldItems, prices) / totalSold(soldItems));
    }

    public double totalCost(Map<Integer, Integer> soldItems, Map<Integer, Double> cost) {
        double sum = 0;
        for (Integer key : soldItems.keySet()) {
            double value1 = soldItems.get(key);
            double value2 = cost.get(key);
            sum += value1 * value2;
        }
        return RoundUtil.up(sum);
    }

    public double totalProfit(Map<Integer, Integer> soldItems, Map<Integer, Double> prices, Map<Integer, Double> cost) {
        return RoundUtil.up(TaxUtil.CorporateIncomeTax(totalRevenue(soldItems, prices) -
                TaxUtil.VATonRevenue(totalRevenue(soldItems, prices)) - totalCost(soldItems, cost)));
    }

    public double profitMargin(Map<Integer, Integer> soldItems, Map<Integer, Double> prices, Map<Integer, Double> cost) {
        return RoundUtil.up(totalProfit(soldItems, prices, cost) / totalRevenue(soldItems, prices) * 100);
    }
}
