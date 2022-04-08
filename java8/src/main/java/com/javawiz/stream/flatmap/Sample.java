package com.javawiz.stream.flatmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Java Stream flatMap() is a very useful function to flatten the Stream after applying the given function to all the elements of the stream.
 */
public class Sample {
    public static void main(String[] args) {

        List<String> l1 = Arrays.asList("a","b");
        List<String> l2 = Arrays.asList("c","d");
        List<String> l = new ArrayList<>();
        l.addAll(l1);
        l.addAll(l2);

        List<String> letters = l.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("map result -> ");
        letters.forEach(System.out::println);

        System.out.println("====================");
        List<String> newList = Stream.concat(l1.stream(), l2.stream())
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("flatmap result -> ");
        newList.forEach(System.out::println);

        System.out.println("====================");
        List<String> betterLetters = Stream.of(l1, l2)
                .flatMap(List::stream)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("flatmap result -> ");
        betterLetters.forEach(System.out::println);

    }
}
