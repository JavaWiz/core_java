package com.javawiz.lambda;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Sample {
    public static void main(String[] args) {
        Predicate<String> stringPredicate = s -> s.isEmpty();
        Predicate<List> listPredicate = s -> s.isEmpty();
        Function<String, Boolean> func = s -> s.isEmpty();
        Consumer<String> consumer = s -> s.isEmpty();
        Supplier<String> supplier;

        System.out.println(func.apply("Ranjan"));
        consumer.accept("Ranjan");
        
        
        TaskComparator c = (i, j) -> i > j;
        boolean result = c.compare(5, 4);
        System.out.println(result);
    }
}
