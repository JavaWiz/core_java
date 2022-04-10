package com.javawiz.supplier;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.function.Supplier;

public class SupplierThree {

    public static void main(String[] args) {

        Developer obj = factory(Developer::new);
        System.out.println(obj);

        Developer obj2 = factory(() -> new Developer("Ranjan"));
        System.out.println(obj2);

    }

    public static Developer factory(Supplier<? extends Developer> s) {

        Developer developer = s.get();
        if (developer.getName() == null || "".equals(developer.getName())) {
            developer.setName("default");
        }
        developer.setSalary(BigDecimal.ONE);
        developer.setStart(LocalDate.of(2017, 8, 8));
        return developer;
    }
}