/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.model;

import com.peregud.pizza.annotations.DBFieldName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @DBFieldName(key = "customer_id")
    private int id;
    @DBFieldName(key = "first_name")
    private String firstName;
    @DBFieldName(key = "last_name")
    private String lastName;
    @DBFieldName(key = "card_number")
    private String cardNumber;
    @DBFieldName(key = "order_id")
    private int orderID;
}
