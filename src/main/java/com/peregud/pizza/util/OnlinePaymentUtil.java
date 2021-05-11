/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.util;

import com.peregud.pizza.dao.service.DAOCustomerService;
import lombok.experimental.UtilityClass;

@UtilityClass
public class OnlinePaymentUtil {
    private final DAOCustomerService CUSTOMER = new DAOCustomerService();

    public void addCustomer() {
        CUSTOMER.saveNewData();
    }
}
