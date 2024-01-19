package com.javawiz.interview;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import com.javawiz.model.Order;

public class Java8InterviewQ1 {

	public static void main(String[] args) {
		Map<Integer, Order> map = new HashMap<>();
		map.put(1, new Order(1, "Channai"));
		map.put(2, new Order(2, "Mumbai"));
		map.put(2, new Order(2, "Mumbai"));
		map.put(3, new Order(2, "Kolkata"));
		
		System.out.println(map);
		
		Map<Integer, Order> result = map.entrySet().stream()
		.filter(entry -> "Mumbai".equals(entry.getValue().getLocation()))
		.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		
		System.out.println(result);
	}
}
