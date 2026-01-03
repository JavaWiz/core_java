package com.javawiz.interview.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class ArrayExample {

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4};
        List<Integer> list = getIntegers(numbers);
        System.out.println("Sum of array elements: " + list);
        List<Integer> listSecondWay = getIntegersSecondWay(numbers);
        System.out.println("Sum of array elements (2nd way): " + listSecondWay);
        int[] premitiveArray = getPremitiveArray(numbers);
        System.out.println("Sum of array elements (premitive array): " + Arrays.toString(premitiveArray));
    }

    private static List<Integer> getIntegers(int[] numbers) {
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        for (int number : numbers) {
            list.add(sum += number);
        }
        return list;
    }

    private static List<Integer> getIntegersSecondWay(int[] numbers) {
        AtomicInteger sum = new AtomicInteger();
        return Arrays.stream(numbers)
            .map(sum::addAndGet)
            .boxed()
            .collect(Collectors.toList());
    }

    private static int[] getPremitiveArray(int[] numbers) {
        AtomicInteger sum = new AtomicInteger();
        return Arrays.stream(numbers)
            .map(sum::addAndGet)
            .toArray();
    }
}
