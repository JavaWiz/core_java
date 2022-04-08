package com.javawiz.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Address {
    private int addressId;
    private String city;
    private int zipCode;
    private String state;
}
