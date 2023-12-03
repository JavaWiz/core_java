package com.javawiz.interview;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class NthHighestSalary {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("User1", 150000);
		map.put("User2", 120000);
		map.put("User3", 130000);
		map.put("User4", 140000);
		map.put("User5", 130000);
		map.put("User6", 150000);
		map.put("User7", 120000);
		map.put("User8", 150000);
		System.out.println(getNthHighestSalaryEmployee(1, map));
	}

	private static Map.Entry<Integer, List<String>> getNthHighestSalaryEmployee(int n, Map<String, Integer> map) {
		List<Entry<Integer, List<String>>> result = map.entrySet().stream()
				.collect(Collectors.groupingBy(Map.Entry::getValue, 
						Collectors.mapping(Map.Entry::getKey, Collectors.toList())))
				.entrySet().stream()
				.sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
				.collect(Collectors.toList());
		return n<=result.size() ? result.get(n-1) : null;
	}
}
