/*
 * Copyright (c) 2021. Oxana Peregud.
 * All rights reserved.
 */

package com.peregud.pizza.model;

import com.peregud.pizza.annotations.DBFieldName;
import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @DBFieldName(key = "address_id")
    private int id;
    @DBFieldName(key = "street")
    private String street;
    @DBFieldName(key = "house")
    private int house;
    @DBFieldName(key = "apartment")
    private int apartment;
}
