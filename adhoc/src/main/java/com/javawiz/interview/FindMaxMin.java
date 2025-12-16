package com.javawiz.interview;

public class FindMaxMin {

    public static void main(String[] args) {
        int[] arr = {3, 5, 1, 8, -2, 7, 4};
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }
        System.out.println("Max: " + max + ", Min: " + min);
    }
}
