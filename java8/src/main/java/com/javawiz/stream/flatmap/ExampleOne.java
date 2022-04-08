package com.javawiz.stream.flatmap;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * In Java 8, Stream can hold different data types, for examples:
 *
 * Stream<String[][]>
 * Stream<Set<String>>
 * Stream<List<String>>
 * Stream<List<Object>>
 *
 * But, the Stream operations (filter, sum, distinct…) and collectors do not support it,
 * so, we need flatMap() to do the following conversion :
 *
 * Stream<String[]>		-> flatMap ->	Stream<String>
 * Stream<Set<String>>	-> flatMap ->	Stream<String>
 * Stream<List<String>>	-> flatMap ->	Stream<String>
 * Stream<List<Object>>	-> flatMap ->	Stream<Object>
 */

public class ExampleOne {
    public static void main(String[] args) {
        String[][] data = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};
        withoutFlatmap(data);
        System.out.println("=======================");
        applyFlatmap(data);
    }

    //The below example will print an empty result, because filter() has no idea how to filter a stream of String[].
    public static void withoutFlatmap(String[][] data){
        //Stream<String[]>
        Stream<String[]> temp = Arrays.stream(data);

        //filter a stream of string[], and return a string[]?
        Stream<String[]> stream = temp.filter(x -> "a".equals(x.toString()));

        stream.forEach(System.out::println);
    }

    //In above example, we should use flatMap() to convert Stream<String[]> to Stream<String>.
    public static void applyFlatmap(String[][] data){
        //Stream<String[]>
        Stream<String[]> temp = Arrays.stream(data);

        //applyFlatMap
        Stream<String> flatten = temp.flatMap(x -> Arrays.stream(x));

        //filter a stream of string[], and return a string[]?
        Stream<String> stream = flatten.filter(x -> "a".equals(x.toString()));

        stream.forEach(System.out::println);
    }
}
