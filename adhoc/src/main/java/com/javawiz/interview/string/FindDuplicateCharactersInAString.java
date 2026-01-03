package com.javawiz.interview.string;

import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindDuplicateCharactersInAString {

    public static void main(String[] args) {
        String str = "programming";
        findDuplicates(str);

    }

    private static void findDuplicates(String input) {
        Set<Character> result = input.chars()
            .mapToObj(c -> (char)c)
            .collect(Collectors.groupingBy(Function.identity(),
                                           Collectors.counting()))
            .entrySet().stream()
            .filter(e -> e.getValue() > 1)
            .map(Map.Entry::getKey)
            .collect(Collectors.toSet());
        System.out.println("Repeated characters: " + result);
    }
}
