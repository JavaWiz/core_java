package com.javawiz.stream.max;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class MaxExample {

    public static void main(String[] args) {
        List<Integer> listOfIntegers = Arrays.asList(1, 2, 3, 4, 56, 7, 89, 10);
        Integer max = listOfIntegers
            .stream()
            .mapToInt(v -> v)
            .max()
            .orElse(0);
            //.orElseThrow(NoSuchElementException::new);
        System.out.println(max);
    }
}
