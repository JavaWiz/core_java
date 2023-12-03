package com.javawiz.algorithm.sort;

import java.util.Arrays;

public class QSTest {

	public static void main(String[] args) {
		int a[] = {64, 34, 25, 12, 25, 22, 11, 90, 11, 34};
		Quicksort qs = new Quicksort();
		System.out.println(Arrays.toString(a));
		qs.sort(a);
		System.out.println(Arrays.toString(a));
	}
}
