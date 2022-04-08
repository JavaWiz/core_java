package com.javawiz.stream;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortMapByValues {

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>();
		map.put(4, "B");
		map.put(2, "A");
		map.put(1, "C");
		map.put(3, "A");
		System.out.println(sortByValue(map));
	}

	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
		return map.entrySet().stream()
				.sorted(Map.Entry
						.comparingByValue(/* Collections.reverseOrder() */))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
	}

}
