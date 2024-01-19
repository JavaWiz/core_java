package com.javawiz.algorithm.sort;

import java.util.Arrays;
/*
 * Here in this sort we assume the first element is small, if not we swap
 * In one iteration we swap once.
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] a = new int[]{ 9, 1, 8, 6, 3 , 7, 2, 5, 4};
        int n = a.length;
        for (int i = 0; i<a.length-1; i++){
        	//assume the first element is small
        	int smallest = i;
            for(int j = i+1; j< a.length; j++){
            	System.out.println("* i -> "+i+", j = "+j+" -> "+ Arrays.toString(a));
                if(a[smallest] > a[j]){
                    smallest = j;
                }
            }
            System.out.println("* smallest index at "+smallest+" in -> "+ Arrays.toString(a));
            // Swap the found minimum element with the first element
            int tmp = a[smallest];
            a[smallest] = a[i];
            a[i] = tmp;
        }
        System.out.println("Sorted array -> "+Arrays.toString(a));
    }
}
