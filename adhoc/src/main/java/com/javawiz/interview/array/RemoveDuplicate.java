package com.javawiz.interview.array;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicate {

    public static void main(String[] args) {

        int[] arr = {1, 2, 2, 3, 4, 4, 5, 5, 5, 6};
        int[] result = removeDuplicatesStream(arr);
        System.out.println("Array after removing duplicates: " + Arrays.toString(result));
        System.out.println("Array after removing duplicates lagacy way: " + Arrays.toString(removeDuplicatesLegacyWay(arr)));
    }

    // using two pointers
    private static int removeDuplicates(int[] array) {
        int i =0;
        for(int j=1; j<array.length; j++){
            if(array[i] != array[j]){
                i++;
                array[i] = array[j];
            }
        }
        reconstructArray(array, i);
        return i+1;
    }

    private static void reconstructArray(int[] array, int i) {
        int[] arrayCopy = new int[i+1];
        for(int j=0; j<arrayCopy.length; j++){
            arrayCopy[j] = array[j];
        }
        Arrays.stream(arrayCopy).forEach(System.out::println);
    }

    public static int[] removeDuplicatesLegacyWay(int[] arr) {
        Set<Integer> set = new LinkedHashSet<>();
        for (int num : arr) {
            set.add(num);
        }
        return set.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] removeDuplicatesStream(int[] arr) {
        return Arrays.stream(arr).distinct().toArray();
    }
}
