package com.javawiz.algorithm.sort;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort {
    public static void main(String[] args) {
    	Random random = new Random();
		int[] a = new int[10];
		
		for (int i = 0; i < a.length; i++) {
			a[i] = random.nextInt(100);
		}
		
        sort(a);// some how improved because we avoid last element
        //sortAnotherWay(a);//but not good
        sortInBetterWay(a);
    }

	public static void sort(int[] a) {
		int counter = 0;
		for (int i = 0; i<a.length; i++) {
            System.out.println("i = "+i+" -> "+Arrays.toString(a));
            for (int j = 1; j <a.length-i; j++) {
                if (a[j] < a[j - 1]) {
                    int small = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = small;
                }
                System.out.println((counter++)+": j = "+j+" -> "+Arrays.toString(a));
            }
        }
	}
	
	public static void sortInBetterWay(int[] a) {
		int counter = 0;
		boolean isSorted;
		for (int i = 0; i<a.length; i++) {
			isSorted = true;
            System.out.println("i = "+i+" -> "+Arrays.toString(a));
            for (int j = 1; j <a.length-i; j++) {
                if (a[j] < a[j - 1]) {
                    int small = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = small;
                    isSorted = false;
                }
                System.out.println((counter++)+": j = "+j+" -> "+Arrays.toString(a));
            }
            if(isSorted)return;
        }
			
	}
	
	public static void sortAnotherWay(int[] a) {
		int counter = 0;
		boolean isSwapRequired = true;
		while(isSwapRequired) {
			isSwapRequired = false;
			for (int i = 0; i<a.length-1; i++) {
				System.out.println((counter++)+":i = "+i+" -> "+Arrays.toString(a));
				if(a[i]>a[i+1]) {
					isSwapRequired = true;
					int big = a[i];
					a[i] = a[i+1];
					a[i+1]= big;
				}
			}
		}
	}
}
