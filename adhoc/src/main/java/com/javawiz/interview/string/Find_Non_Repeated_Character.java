package com.javawiz.interview.string;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

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

    //Optimized traditional version
    private static void optimized_traditional_version(String s){//(O(n)) because of indexOf and lastIndexOf
        Map <Character, Integer> charCountMap = new HashMap<>();
        for(char c : s.toCharArray()){
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        for (char c : s.toCharArray()) {
            if (charCountMap.get(c) == 1) {
                System.out.println("First non-repeated character:" + c);
                return;
            }
        }
        System.out.println("No non-repeated character found.");
    }

    private static void firstNonRepeatedCharacter(String s) {
        Map<Integer, Long> charCountMap = s.chars()
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
            .boxed()
            .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
            .entrySet()
            .stream()
            .filter(entry -> entry.getValue() == 1)
            .map(e -> (char)e.getKey().intValue())
            .findFirst()
            .ifPresentOrElse(
                c -> System.out.println("First non-repeated character: " + c),
                () -> System.out.println("No non-repeated character found.")
            );
    }
}

