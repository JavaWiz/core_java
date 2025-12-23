package com.javawiz.interview.array;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MergeArrayFindMid {

    public static void main(String[] args) {
        int[] arr1 = /*{1, 3};*/ {-5, 3, 6, 15, 12};
        int[] arr2 = /*{2};*/{-12, -10, -6, -3, 4};
        System.out.println("Median: " + findMedianSortedArrays(arr1, arr2));
    }

    private static String findMedianSortedArrays(int[] arr1, int[] arr2) {
        // Ensure both arrays are sorted before merging
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int m = arr1.length;
        int n = arr2.length;
        int[] merged = new int[m + n];
        int i = 0, j = 0, k = 0;

        while (i < m && j < n) {
            if (arr1[i] < arr2[j]) {
                merged[k++] = arr1[i++];
            } else {
                merged[k++] = arr2[j++];
            }
        }
        System.out.println(Arrays.toString(merged));
        while (i < m) {
            merged[k++] = arr1[i++];
        }

        while (j < n) {
            merged[k++] = arr2[j++];
        }
        System.out.println(Arrays.toString(merged));
        double median;
        int totalLength = m + n;
        if (totalLength % 2 == 0) {
            median = (merged[totalLength / 2 - 1] + merged[totalLength / 2]) / 2.0;
        } else {
            median = merged[totalLength / 2];
        }

        if (median == (int) median) {
            return String.valueOf((int) median);
        } else {
            return String.valueOf(median);
        }
    }

    //java 8 stream solution
    static String findMedianSortedArraysJava8(int[] arr1, int[] arr2) {
        int[] merged = IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2))
                //.sorted()
                .toArray();

        double median;
        int totalLength = merged.length;
        if (totalLength % 2 == 0) {
            median = (merged[totalLength / 2 - 1] + merged[totalLength / 2]) / 2.0;
        } else {
            median = merged[totalLength / 2];
        }

        if (median == (int) median) {
            return String.valueOf((int) median);
        } else {
            return String.valueOf(median);
        }
    }
}
