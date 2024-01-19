package com.javawiz.interview;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Sample4 {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(12, 2, 4, 12, 5, 2, 2, 8, 4, 3);
		
		Map<Integer, Long> map = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		map.entrySet()
		.stream()
		.filter(entry -> entry.getValue()>1)
		.forEach(entry -> System.out.println(entry.getKey()+" : "+entry.getValue()));
		
		Integer max = map.entrySet()
				.stream()
				.max((entry1, entry2) -> entry1.getValue().compareTo(entry2.getValue()))
				.get()
				.getKey();
		System.out.println(max);
		
		System.out.println("=============================");
		map.entrySet()
				.stream()
				.max(Map.Entry.comparingByValue())
				.ifPresent(entry -> System.out.println(entry.getValue()));
		System.out.println("=============================");
	}
}
