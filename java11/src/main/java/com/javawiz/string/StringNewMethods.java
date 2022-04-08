package com.javawiz.java11.string;

import java.util.List;
import java.util.stream.Collectors;

public class StringNewMethods {
    public static void main(String[] args) {
        List<String> lines = sample();
        System.out.println(lines);
    }

    public static List<String> sample(){
        String multilineString = "Baeldung helps \n \n developers \n explore Java.";
        return multilineString.lines()
                .filter(line -> !line.isBlank())
                .map(String::strip)
                .collect(Collectors.toList());
    }
}
