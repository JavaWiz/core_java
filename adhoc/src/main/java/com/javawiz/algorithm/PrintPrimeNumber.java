package com.javawiz.algorithm;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrintPrimeNumber {

    public static void main(String[] args) {

        long count = Stream.iterate(0, n -> n + 1)
                .limit(100)
                .filter(PrintPrimeNumber::isPrime)
                .peek(x -> System.out.format("%s\t", x))
                .count();

        System.out.println("\nTotal: " + count);

    }

    public static boolean isPrime(int number) {
        // 1 is not prime and also not composite
        return number > 1 && IntStream.rangeClosed(2, number / 2).noneMatch(i -> number % i == 0);
    }

    public static boolean isPrimeNumber(int x){
        if(x<2) return false;

        if(x!=2 && x%2==0) return false;

        for(int i=3;i*i<x;i+=2) {
            System.out.println(i);
            if(x%i == 0) return false;
        }
        return true;
    }
}