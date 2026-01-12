package com.javawiz.interview.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MostRepeatedWordExample {

    public static void main(String[] args) {
        String sentence = "java is great and java is powerful";
        System.out.println("Most repeated word: " + findMostRepeatedWord(sentence));
        System.out.println("All most repeated words: " + findAllMostRepeatedWords(sentence));
    }

    private static String findMostRepeatedWord(String sentence) {
        return Arrays.stream(sentence.split("\\W+"))
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
            .entrySet().stream()
            .max(Entry.comparingByValue())
            .get().getKey();
    }

    private static List<String> findAllMostRepeatedWords(String sentence) {
        Map<String, Long> wordCounts = Arrays.stream(sentence.split("\\W+"))
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        long maxCount = wordCounts.values().stream().max(Long::compare).orElse(0L);
        return wordCounts.entrySet().stream()
            .filter(e -> e.getValue() == maxCount)
            .map(Entry::getKey)
            .collect(Collectors.toList());
    }
}
