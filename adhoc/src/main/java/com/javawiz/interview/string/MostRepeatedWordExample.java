package com.javawiz.interview.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MostRepeatedWordExample {

    public static void main(String[] args) {
        String sentence = "java is great and java is powerful";
        String mostRepeatedWord = findMostRepeatedWord(sentence);
        System.out.println("Most repeated word: " + mostRepeatedWord);
    }

    private static String findMostRepeatedWord(String sentence) {
        return Arrays.stream(sentence.split(" "))
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
            .entrySet().stream().max(Map.Entry.comparingByValue())
            .get().getKey();
    }
}
