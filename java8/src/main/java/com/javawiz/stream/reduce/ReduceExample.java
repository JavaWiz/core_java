package com.javawiz.stream.reduce;

import java.util.Arrays;
import java.util.List;

public class ReduceExample {
	public static void main(String[] args) {
		
		List<Integer> integers = Arrays.asList(1, 1, 1);
		Integer reduced = integers.stream().reduce(23, (a, b) -> a + b);
		
		System.out.println(reduced);

	}

}
