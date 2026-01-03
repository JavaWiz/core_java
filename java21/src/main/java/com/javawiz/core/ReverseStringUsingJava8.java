package com.javawiz.core;

import java.util.Arrays;
import java.util.Collections;

public class ReverseStringUsingJava8 {

    public static void main(String[] args) {
        String input = "Hello, Java 8!"; //olleH ,8 avaJ
        String reversed = reverseString(input);
        System.out.println("Reversed String: " + reversed);
        System.out.println("Reversed Words: " + reverseWords(input));
        System.out.println("Reversed Words (Java 8): " + reverseWordsJava8(input));
        System.out.println("Reversed Each Word: " + reverseEachWord(input));
    }

    private static String reverseString(String input) {
        return input.chars()
                .mapToObj(c -> (char) c)
                .reduce("", (s, c) -> c + s, (s1, s2) -> s2 + s1);// Identity, Accumulator, Combiner
    }

    public static String reverseWords(String input) {
        String[] words = input.trim().split("\\s+");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }

    public static String reverseWordsJava8(String input) {
        return Arrays.stream(input.trim().split("\\s+"))
                .reduce("", (s1, s2) -> s2 + " " + s1).trim();
    }

    public static String reverseEachWord(String input) {
        return Arrays.stream(input.split(" "))
            .map(word -> new StringBuilder(word).reverse().toString())
            .reduce((a, b) -> a + " " + b)
            .orElse("");
    }

}
