package com.javawiz.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

public class SampleExampleOne {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> output = strings.stream().filter(data -> !data.isEmpty()).collect(Collectors.toList());
        output.forEach(System.out::println);
        System.out.println("-------------------------");
        //print 10 random numbers using forEach

        System.out.println("--------------------------");
        //The ‘map’ method is used to map each element to its corresponding result.
        //prints unique squares of numbers using map.
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        numbers.stream().map(i -> i*i).distinct().forEach(System.out::println);
        System.out.println("--------------------------");
        //The ‘filter’ method is used to eliminate elements based on a criteria.
        //prints a count of empty strings using filter.
        List<String> strings1 = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        long count  = strings1.stream().filter(data -> data.isEmpty()).count();
        System.out.println("Count: "+count);
        System.out.println("---------------------------");
        //The ‘limit’ method is used to reduce the size of the stream.
        //print 10 random numbers using limit.
        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);
        System.out.println("----------------------------");
        //The ‘sorted’ method is used to sort the stream.
        //print 10 random numbers in a sorted order.
        Random random2 = new Random();
        random.ints().limit(10).sorted().forEach(System.out::println);
        System.out.println("-----------------------------");
        //parallelStream is the alternative of stream for parallel processing.
        //prints a count of empty strings using parallelStream.
        long count1 = strings1.parallelStream().filter(str -> str.isEmpty()).count();
        System.out.println("Count: "+count1);
        System.out.println("------------------------------");
        Integer value1 = null;
        Integer value2 = 10;

        //Optional.ofNullable - allows passed parameter to be null.
        Optional<Integer> a = Optional.ofNullable(value1);
    }
}
