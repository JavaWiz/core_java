package com.javawiz.stream.shortcircuit;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LimitExample {

    public static void main (String[] args) {
        int[] ints = {1, 2, 3, 4, 5, 6};

        System.out.printf("Source: %s%n", Arrays.toString(ints));
        System.out.println("Finding even numbers.");
        //we are creating and passing new stream instance from the same source to the methods, runWithLimit(..) and runWithoutLimit(..).
        //A stream cannot be reused after a terminal operation is called.
        runWithoutLimit(Arrays.stream(ints));
        runWithLimit(Arrays.stream(ints));
        
        System.out.println("=============================");
        //Infinite streams and limit() method
        Stream.iterate(1, i -> i + 1)
        .filter(i -> i % 2 == 0)
              .limit(5)
              .forEach(System.out::println);
        
        //If we remove limit(5) part, it will be printing even numbers forever.
        //An infinite streams is desirable where size of the data source is not known in advance, 
        //for example, data coming as messages from a remote location or data generated to show some GUI animations.
        //In above example, what if we use the limit(5) first and then apply the filter later? 
        //It's not relevant to the current topic but just see the outcome:
        System.out.println("=============================");
        Stream.iterate(1, i -> i + 1)
        .limit(5)
        .filter(i -> i % 2 == 0)
        .forEach(System.out::println);
        //That shows that order matters while performing intermediate operations.
    }

    private static void runWithoutLimit (IntStream stream) {
        System.out.println("Running without limit()");

        //filter even numbers
        stream.filter(i -> i % 2 == 0)
              .forEach(System.out::println);
    }

    private static void runWithLimit (IntStream stream) {
        System.out.println("Running with limit(2)");

        //filter even numbers
        stream.filter(i -> i % 2 == 0)
              .limit(2)
              .forEach(System.out::println);
    }
}