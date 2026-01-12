package com.javawiz.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Java8ComparatorNaturalOrder {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Charlie", "Alice", "Bob");

        // Using Comparator.naturalOrder() to sort the list in natural order
        names.sort(Comparator.naturalOrder());

        System.out.println(names);
        // Output: [Alice, Bob, Charlie]
    }
}
