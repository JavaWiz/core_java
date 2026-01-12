package com.javawiz.array;

public class FindDuplicate {
    public static void main(String[] args) {
    	int[] array = {1, 3, 3, 4, 5, 5, 6, 7, 17};
        //duplicate(array);
        printRepeating(array);
    }

    public static void printRepeating(int[] arr) {

        System.out.println("Repeated elements are : ");
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                System.out.print(arr[i] + " ");

            }
        }
    }
}
