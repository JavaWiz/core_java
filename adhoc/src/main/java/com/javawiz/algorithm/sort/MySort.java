package com.javawiz.algorithm.sort;

import java.util.Random;

public class MySort {

	public static void main(String[] args) {
		Random random = new Random();
		int[] numbers = new int[10];
		
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = random.nextInt(100);
		}
		
		System.out.println("Before sort:");
		printArray(numbers);
		//sortWithInsertionSortAlgo(numbers);
		sortWithBubbleSortAlgo(numbers);
		
		System.out.println("\nAfter sort:");
		printArray(numbers);
	}

	public static void printArray(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i]+" ");
		}
	}
	
	private static void sortWithBubbleSortAlgo(int[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 1; j < a.length; j++) {
				if(a[j]<a[j-1]) {
					int small = a[j];
					a[j] = a[j-1];
					a[j-1] = small;
				}
			}
		}
	}

	private static void sortWithInsertionSortAlgo(int[] numbers) {
		for (int i = 1; i < numbers.length; i++) {
			int current = numbers[i];
			int j = i-1;
			while(j>=0 && numbers[j]>current){
				numbers[j+1] = numbers[j];
				j--;
			}
			numbers[j+1] = current;
		}
	}

}
