/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.util;

import com.peregud.pizza.dao.controller.DAOCustomerController;
import lombok.experimental.UtilityClass;

@UtilityClass
public class OnlinePaymentUtil {
    private final DAOCustomerController CUSTOMER = new DAOCustomerController();

    public void addCustomer() {
        CUSTOMER.saveNewData();
    }
}
