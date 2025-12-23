package com.javawiz.interview.array;

import java.util.Arrays;

public class RemoveDuplicate {

    public static void main(String[] args) {

        int[] arr = {1, 2, 2, 3, 4, 4, 5, 5, 5, 6};
        int[] result = removeDuplicates(arr);
        System.out.println("Array after removing duplicates: " + Arrays.toString(result));
        System.out.println("Array after removing duplicates lagacy way: " + Arrays.toString(removeDuplicatesLegacyWay(arr)));
    }

    // Method to remove duplicates from an array legacy way
    public static int[] removeDuplicatesLegacyWay(int[] arr){
        int n = arr.length;
        if (n == 0 || n == 1) {
            return arr;
        }
        Arrays.sort(arr); // Sort the array
        int[] temp = new int[n];
        int j = 0;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                temp[j++] = arr[i]; // add unique element to temp array
            }
        }
        temp[j++] = arr[n - 1]; // add the last element
        System.out.println("Temp array with unique elements: " + Arrays.toString(temp));
        int[] result = new int[j];
        System.arraycopy(temp, 0, result, 0, j); // Copy unique elements to result array
        return result;
    }

    public static int[] removeDuplicates(int[] arr) {
        return Arrays.stream(arr).distinct().toArray();
    }

}
