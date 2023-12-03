package com.javawiz.algorithm.sort;

import java.util.Arrays;
import java.util.Random;

public class InsertionSort {
    public static void main(String[] args) {
    	Random random = new Random();
		int[] a = new int[10];
		
		for (int i = 0; i < a.length; i++) {
			a[i] = random.nextInt(100);
		}
		
        sort(a);
        System.out.println(Arrays.toString(a));

    }

	public static void sort(int[] a) {
		for (int i = 1; i<a.length; i++) {
        	int current = a[i];
            int j = i-1;
            while (j >= 0 && a[j] > current) {
                System.out.println("* i -> "+i+", j = "+j+" -> "+ Arrays.toString(a));
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = current;
            System.out.println("# i -> "+i+", j = "+j+" -> "+ Arrays.toString(a));
        }
	}
}
