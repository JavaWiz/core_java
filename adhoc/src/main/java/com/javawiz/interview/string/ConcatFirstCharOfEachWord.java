package com.javawiz.interview.string;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ConcatFirstCharOfEachWord {

    public static void main(String[] args) {
        String s = "find the first char of word and concat it";
        System.out.println(firstWay(s));
        System.out.println(secondWay(s));
    }

    private static String firstWay(String s) {
       return Arrays.stream(s.split("\\W"))
                    .map(word -> String.valueOf(word.charAt(0)))
                    .reduce("", String::concat);
    }

    private static String secondWay(String s) {
        return Arrays.stream(s.split("\\W"))
            .map(word -> String.valueOf(word.charAt(0)))
            .collect(Collectors.joining(""));
    }
}
