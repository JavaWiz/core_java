package com.javawiz;

public class ReverseStringUsingJava8 {

    public static void main(String[] args) {
        String input = "Hello, Java 8!"; //olleH ,8 avaJ
        String reversed = reverseString(input);
        System.out.println("Reversed String: " + reversed);
    }



    private static String reverseString(String input) {
        return input.chars()
                .mapToObj(c -> (char) c)
                .reduce("", (s, c) -> c + s, (s1, s2) -> s2 + s1);
    }
}
