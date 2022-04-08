package com.javawiz.java11.string;

import java.util.List;
import java.util.stream.Collectors;

public class StringExample {
    public static void main(String[] args) {
        String multilineString = "Baeldung helps \n \n developers \n explore Java.";
        List<String> lines = multilineString.lines()
                .filter(line -> !line.isBlank())
                .map(String::strip)
                .collect(Collectors.toList());
        //assertThat(lines).containsExactly("Baeldung helps", "developers", "explore Java.");
    }
}
