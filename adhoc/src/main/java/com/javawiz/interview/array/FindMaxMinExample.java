package com.javawiz.interview.array;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FindMaxMinExample {

    public static void main(String[] args) {
        int[] array = {34, 12, 51, 67, 23, 89, 21};
        traditionalWay(array);
        arrayStreamWay(array);
        findMaxMinUsingIntSummaryStatistics(array);

        Integer[] array2 = {34, 12, 51, 67, 23, 89, 21};
        IntegerStreamWay(array2);
    }

    private static void IntegerStreamWay(Integer[] array2) {
        int min = Stream.of(array2).mapToInt(Integer::intValue).min().getAsInt();
        int max = Stream.of(array2).mapToInt(Integer::intValue).max().getAsInt();
        System.out.println("Minimum: " + min);
        System.out.println("Maximum: " + max);
    }

    private static void traditionalWay(int[] array) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : array) {
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }
        System.out.println("Minimum: " + min);
        System.out.println("Maximum: " + max);
    }

    /**
     * Uses primitive stream → no boxing overhead.
     * getAsInt() is safe if array is non-empty
     * @param array
     */
    private static void arrayStreamWay(int[] array) {
        int min = Arrays.stream(array).min().getAsInt();
        int max =Arrays.stream(array).max().getAsInt();
        System.out.println("Minimum: " + min);
        System.out.println("Maximum: " + max);
    }
    // array to IntStream
    private static void intStreamWay(int[] array) {
        int min = IntStream.of(array).min().getAsInt();
        int max = IntStream.of(array).max().getAsInt();
        System.out.println("Minimum: " + min);
        System.out.println("Maximum: " + max);
    }

    /*
    💡 Why this is best in real systems
        Traverses array only once
        Gives min, max, sum, avg, count together
        More efficient than calling min() and max() separately
     *
     */
    public static void findMaxMinUsingIntSummaryStatistics(int[] array) {
        IntSummaryStatistics stats = Arrays.stream(array).summaryStatistics();
        System.out.println("Mini: " + stats.getMin());
        System.out.println("Maximum: " + stats.getMax());
    }

    private static void null_empty_Safe_Version(int[] array){
        OptionalInt min = Arrays.stream(array).min();
        OptionalInt max = Arrays.stream(array).max();

        min.ifPresent(v -> System.out.println("Min = " + v));
        max.ifPresent(v -> System.out.println("Max = " + v));
        min.ifPresentOrElse(v -> System.out.println("Min = " + v), ()-> System.out.println("No element found"));
        max.ifPresentOrElse(v -> System.out.println("Max = " + v), ()-> System.out.println("No element found"));
    }
}
