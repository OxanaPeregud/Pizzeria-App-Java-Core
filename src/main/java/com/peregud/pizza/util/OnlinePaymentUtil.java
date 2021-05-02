package com.peregud.pizza.util;

import com.peregud.pizza.service.CustomerService;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OnlinePaymentUtil {
    private static final CustomerService CUSTOMER = new CustomerService();

    public static void addCustomer() {
        CUSTOMER.saveNewData();
    }
}
