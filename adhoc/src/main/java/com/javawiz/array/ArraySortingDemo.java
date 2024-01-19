package com.javawiz.array;

import java.util.Arrays;

public class ArraySortingDemo {
	public static void main(String[] args) {
		//Declaring array of float elements  
		float[] resultArray = { 69.4f, 75.3f, 43.22f, 55.21f, 35.87f, 87.02f };
		System.out.println("Array Before Sorting- " + Arrays.toString(resultArray));
		//Below line will sort the array in ascending order  
		Arrays.sort(resultArray);
		System.out.println("Array After Sorting- " + Arrays.toString(resultArray));
	}
}
