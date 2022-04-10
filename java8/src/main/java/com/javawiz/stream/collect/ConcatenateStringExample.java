package com.javawiz.stream.collect;

import java.util.Arrays;
import java.util.List;

public class ConcatenateStringExample {
    public static void main(String[] args) {
        List<String> vowels = Arrays.asList("a", "e", "i", "o", "u");
        // sequential stream - nothing to combine
        StringBuilder result = vowels.stream().collect(StringBuilder::new, StringBuilder::append,
                (a, b) -> a.append(",").append(b));
        System.out.println(result.toString());

        // parallel stream - combiner is combining partial results
        StringBuilder result1 = vowels.parallelStream().collect(StringBuilder::new, StringBuilder::append,
                (a, b) -> a.append(",").append(b));
        System.out.println(result1.toString());
    }
}
