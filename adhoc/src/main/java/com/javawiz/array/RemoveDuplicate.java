package com.javawiz.array;

import java.util.Arrays;

public class RemoveDuplicate  {

    public static void main(String[] args) {
        int[] array = {1, 3, 3, 4, 5, 5, 6, 7};
        int length = removeDuplicates(array);
        System.out.println("Length after removing duplicates: " + length);
        System.out.print("Array after removing duplicates: ");
        for (int i = 0; i < length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    // Function to remove duplicates from a sorted array using two-pointer technique
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
        System.out.print("\nReconstructed Array: ");
        Arrays.stream(arrayCopy).forEach(e -> System.out.print(e + " "));
        System.out.println();
    }
}
