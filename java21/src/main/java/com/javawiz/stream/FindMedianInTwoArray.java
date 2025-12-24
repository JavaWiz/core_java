package com.javawiz.stream;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindMedianInTwoArray {

    public static void main(String[] args) {
        int[] array1 = {1, 3};
        int[] array2 = {2};

        double median = findMedianSortedArrays(array1, array2);
        System.out.println("Median: " + median);
    }

    private static double findMedianSortedArrays(int[] array1, int[] array2) {
        int[] mergedArray = IntStream.concat(Arrays.stream(array1), Arrays.stream(array2)).toArray();
        return findMedian(mergedArray);
    }

    private static double findMedian(int[] numbers) {
        Arrays.sort(numbers);
        int length = numbers.length;

        if (length % 2 == 0) {
            return (numbers[length / 2 - 1] + numbers[length / 2]) / 2.0;
        } else {
            return numbers[length / 2];
        }
    }
}
