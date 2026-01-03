package com.javawiz.interview.array;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicate {

    public static void main(String[] args) {

        int[] arr = {1, 2, 2, 3, 4, 4, 5, 5, 5, 6};
        int[] result = removeDuplicates(arr);
        System.out.println("Array after removing duplicates: " + Arrays.toString(result));
        System.out.println("Array after removing duplicates lagacy way: " + Arrays.toString(removeDuplicatesLegacyWay(arr)));
    }

    public static int[] removeDuplicatesLegacyWay(int[] arr) {
        Set<Integer> set = new LinkedHashSet<>();
        for (int num : arr) {
            set.add(num);
        }
        return set.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] removeDuplicates(int[] arr) {
        return Arrays.stream(arr).distinct().toArray();
    }
}
