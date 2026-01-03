package com.javawiz.algorithm.search;

/**
 * Binary Search Algorithm
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */
public class BinarySearch {
    public static int search(int pivot, int[] array) {
        int start = 0, end = array.length - 1;
        while(start <= end){
            int mid = start + (end - start)/2; // or start + (end - start)/2 to avoid overflow
            if(pivot == array[mid])
                return mid;
            else if(pivot > array[mid])
                start = mid + 1;
            else
                end = mid - 1;
        }
        return -1;
    }
}
