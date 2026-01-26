package com.javawiz.interview.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PairSum {
    public static void main(String[] args) {
        Set<Integer> seen = new HashSet<>();
        int[] input1 = {2, 4, 3, 5, 7, 8, 9};
        int pairSum = 10;

        Arrays.stream(input1)
            .forEach(num -> {
                int complement = pairSum - num;
                if (seen.contains(complement)) {
                    System.out.println(complement + ", " + num);
                } else {
                    seen.add(num);
                }
            });

    }
}
