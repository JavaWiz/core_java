package com.javawiz.interview.string;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
find non-repeated character in a given string using Java 8 Stream API.
 */

public class Find_Non_Repeated_Character {

    public static void main(String[] args) {
        String s = "java programming";
        legacy(s);
        optimized_traditional_version(s);
        firstNonRepeatedCharacter(s);
        streamWay(s);
        anotherStreamWay(s);
    }

    //most simple way
    private static void legacy(String s){//(O(n2)) because of indexOf and lastIndexOf
        for(char c : s.toCharArray()){
            if(s.indexOf(c) == s.lastIndexOf(c)){
                System.out.println("First non-repeated character: " + c);
                return;
            }
        }
        System.out.println("No non-repeated character found.");

    }

    static char findNonRepeated(String s) {
        int[] freq = new int[256];

        for (char c : s.toCharArray()) {
            freq[c]++;
        }

        for (char c : s.toCharArray()) {
            if (freq[c] == 1) {
                return c;
            }
        }
        return '\0'; // not found
    }

    //Optimized traditional version
    // O(n) time: single pass to build frequency map + single pass to find first non-repeated character
    // Worst case: all characters are unique, Map stores n entries so O(n) space
    private static void optimized_traditional_version(String s){
        char result = firstNonRepeatedWithMap(s);
        if(result != '\0'){
            System.out.println("First non-repeated character: " + result);
        } else {
            System.out.println("No non-repeated character found.");
        }
    }

    // Helper method for optimized traditional version
    private static char firstNonRepeatedWithMap(String s) {
        if (s == null || s.isEmpty()) return '\0';

        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : s.toCharArray()) {
            if (map.get(c) == 1) return c;
        }
        return '\0';
    }

    private static void firstNonRepeatedCharacter(String s) {
       Map<Integer, Long> charCountMap =
            s.chars()
            .boxed()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        s.chars()
            .filter(c -> charCountMap.get(c) == 1)
            .mapToObj(c -> (char) c)
            .findFirst()
            .ifPresentOrElse(
                c -> System.out.println("First non-repeated character: " + c),
                () -> System.out.println("No non-repeated character found.")
            );
    }

    private static void streamWay(String s){
       s.chars()
           // Box to Integer stream
            .boxed()
            // Group by character and count occurrences
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
            .entrySet().stream()
            // Filter non-repeated characters
            .filter(entry -> entry.getValue() == 1)
            // Get the first non-repeated character
            .map(e -> (char)e.getKey().intValue())
            .findFirst()
            .ifPresentOrElse(
                c -> System.out.println("First non-repeated character: " + c),
                () -> System.out.println("No non-repeated character found.")
            );
    }

    private static void anotherStreamWay(String input) {
        input.chars()
            .mapToObj(c -> (char)c)
            .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
            .entrySet().stream()
            .filter(e -> e.getValue() == 1)
            .map(Map.Entry::getKey)
            .findFirst()
            .ifPresentOrElse(
                c -> System.out.println("First non-repeated character: " + c),
                () -> System.out.println("No non-repeated character found.")
            );
    }
}

