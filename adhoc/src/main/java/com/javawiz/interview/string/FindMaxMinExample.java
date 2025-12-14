package com.javawiz.interview.string;

public class FindMaxMinExample {

    public static void main(String[] args) {
        int[] array = {34, 12, 51, 67, 23, 89, 21};
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
}
