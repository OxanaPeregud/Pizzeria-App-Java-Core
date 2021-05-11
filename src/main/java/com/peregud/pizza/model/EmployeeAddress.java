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
public class EmployeeAddress {
    @DBFieldName(key = "employee_id")
    private int employeeID;
    @DBFieldName(key = "address_id")
    private int addressID;
}
