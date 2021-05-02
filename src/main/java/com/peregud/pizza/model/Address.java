package com.peregud.pizza.model;

import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private int id;
    private String street;
    private int house;
    private int apartment;
}
