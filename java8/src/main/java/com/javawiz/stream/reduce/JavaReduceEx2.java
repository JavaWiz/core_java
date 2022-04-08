package com.javawiz.stream.reduce;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class JavaReduceEx2 {

    public static void main(String[] args) {

        List<Car> persons = Arrays.asList(new Car("Skoda", 18544),
                new Car("Volvo", 22344),
                new Car("Fiat", 23650),
                new Car("Renault", 19700));

        Optional<Car> car = persons.stream().reduce((c1, c2)
                -> c1.getPrice() > c2.getPrice() ? c1 : c2);

        car.ifPresent(System.out::println);
    }
}