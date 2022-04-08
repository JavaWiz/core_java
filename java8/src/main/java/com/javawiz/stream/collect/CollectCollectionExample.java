package com.javawiz.stream.collect;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectCollectionExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        List<Integer> evenNumbers = numbers.stream().filter(x -> x % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(evenNumbers);  // [2, 4, 6]

        Set<Integer> oddNumbers = numbers.parallelStream().filter(x -> x % 2 != 0)
                .collect(Collectors.toSet());
        System.out.println(oddNumbers); // [1, 3, 5]

        Map<Integer, String> mapOddNumbers = numbers.parallelStream().filter(x -> x % 2 != 0)
                .collect(Collectors.toMap(Function.identity(), String::valueOf));
        System.out.println(mapOddNumbers); // {1=1, 3=3, 5=5}

        String value = Stream.of("a", "b", "c").collect(Collectors.joining());
        System.out.println("value : "+value);
        String valueCSV = Stream.of("a", "b", "c").collect(Collectors.joining(","));
        System.out.println("valueCSV : "+valueCSV);
        String valueCSVLikeArray = Stream.of("a", "b", "c").collect(Collectors.joining(",", "{", "}"));
        System.out.println("valueCSVLikeArray : "+valueCSVLikeArray);
        String valueObject = Stream.of("1", new StringBuffer("2"), new StringBuilder("3")).collect(Collectors.joining());
        System.out.println("valueObject : "+valueObject);
    }
}
