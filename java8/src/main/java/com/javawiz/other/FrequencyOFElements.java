package com.javawiz.other;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FrequencyOFElements {
	public static void main(String[] args) {
		frequencyOfElements();
		
	}

	private static void frequencyOfElements() {
		String s="Ranjan";
		Map<Character, Integer> map = new HashMap<>();
		
		for (char key : s.toCharArray()) {
			Integer value = map.get(key);
			map.put(key, value == null ? 1 : value+1);
		}
		System.out.println(map);
		
		String[] array = s.split("");
		Arrays.stream(array)
		.collect(Collectors.groupingBy(c -> c, Collectors.counting()))
		.forEach((k, v) -> System.out.println(k + ":" + v));
	}
}
