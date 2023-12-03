package com.javawiz.algorithm;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrintPrimeNumber {

    public static void main(String[] args) {

        long count = Stream.iterate(0, n -> n + 1)
                .limit(1000)
                .filter(PrintPrimeNumber::isPrime)
                .peek(x -> System.out.format("%s\t", x))
                .count();

        System.out.println("\nTotal: " + count);

    }

    public static boolean isPrime(int number) {
        return (number <= 1) ? false // 1 is not prime and also not composite
        		: IntStream.rangeClosed(2, number / 2)
        		.noneMatch(i -> number % i == 0);
    }
}