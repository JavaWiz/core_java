package com.javawiz.stream.reduce;

import java.util.Arrays;

public class JavaReduceEx {

    public static void main(String[] args) {
        
        int values[] = { 2, 4, 6, 8, 10, 12, 14, 16 };
        
        int sum = Arrays.stream(values).sum();
        System.out.printf("The sum of values: %d%n", sum);
        
        long n = Arrays.stream(values).count();
        System.out.printf("The number of values: %d%n", n);        
    }
}