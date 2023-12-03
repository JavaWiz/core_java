package com.javawiz.algorithm.search;

public class BinarySearch {
    public static int search(int element, int[] array) {
        int start = 0, end = array.length - 1;
        while(start <= end){
            int mid = (start + end)/2;
            if(element == array[mid])
                return mid;
            else if(element > array[mid])
                start = mid + 1;
            else
                end = mid - 1;
        }
        return -1;
    }
}
