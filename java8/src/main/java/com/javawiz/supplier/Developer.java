package com.javawiz.supplier;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class Developer {
    String name;
    BigDecimal salary;
    LocalDate start;

    // for factory(Developer::new);
    public Developer(){}
    public Developer(String name){
        this.name = name;
    }

}