package com.javawiz.stream.map;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Find out sum of all the integers greater than 10
 *
 */

public class FirstExample {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(12, 34, 9, 15, 20);
		System.out.println("Before Java 8: "+sumIterator(list));
		System.out.println("In Java 8: "+sumStream(list));
	}

	private static int sumIterator(List<Integer> list) {
		Iterator<Integer> it = list.iterator();
		int sum = 0;
		while (it.hasNext()) {
			int num = it.next();
			if (num > 10) {
				sum += num;
			}
		}
		return sum;
	}
	
	private static int sumStream(List<Integer> list) {
		return list.stream().filter(i -> i > 10).mapToInt(i -> i).sum();
	}
}
