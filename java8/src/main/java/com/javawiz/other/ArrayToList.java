package com.javawiz.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayToList {

	public static void main(String[] args) {
		int[] ints = {1, 2, 3};
		List<Integer> list = new ArrayList<Integer>();
		Collections.addAll(list, Arrays.stream(ints).boxed().toArray(Integer[]::new));
		list.forEach(System.out::println);
	}
}
