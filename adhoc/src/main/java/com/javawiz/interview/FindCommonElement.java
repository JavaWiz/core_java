package com.javawiz.interview;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindCommonElement {

	public static void main(String[] args) {
		int ar1[] = { 1, 6, 10, 20, 40, 100, 100 };
		int ar2[] = { 6, 7, 20, 100, 100, 100 };
		int ar3[] = { 2, 4, 15, 20, 30, 75, 100, 100, 120 };
		
		
		List<Integer> output1 = Arrays.stream(ar1).boxed().collect(Collectors.toList());
		List<Integer> output2 = IntStream.of(ar2).boxed().collect(Collectors.toList());
		List<Integer> output3 = IntStream.of(ar3).boxed().collect(Collectors.toList());
		
		
		output1.retainAll(output2);
		System.out.println(output1);
		output1.retainAll(output3);
		System.out.println(output1);
	}

}
