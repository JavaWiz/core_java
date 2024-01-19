package com.javawiz.oop;

import java.util.HashMap;
import java.util.Map;

public class ImmutableMain {
	public static void main(String[] args) {

		Map<String, String> map = new HashMap<>();
		map.put("1", "first");
		map.put("2", "second");

		Student s = new Student("ABC", 101, map);

		// Calling the above methods 1,2,3 of class1
		// inside main() method in class2 and
		// executing the print statement over them
		System.out.println(s.getName());
		System.out.println(s.getId());
		System.out.println(s.getMetadata());

		// Uncommenting below line causes error
		// s.id = 102;

		map.put("3", "third");
		// Remains unchanged due to deep copy in constructor
		System.out.println(s.getMetadata());
		s.getMetadata().put("4", "fourth");
		// Remains unchanged due to deep copy in getter
		System.out.println("Map -> " + s.getMetadata());
	}
}

final class Student {

	private final int id;
	private final String name;
	private final Map<String, String> metadata;

	public Student(String name, int id, Map<String, String> metadata) {
		this.id = id;
		this.name = name;
		Map<String, String> tempMap = new HashMap<>();
		for (Map.Entry<String, String> entry : metadata.entrySet()) {
			tempMap.put(entry.getKey(), entry.getValue());
		}
		this.metadata = tempMap;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public Map<String, String> getMetadata() {
		Map<String, String> tempMap = new HashMap<>();
		for (Map.Entry<String, String> entry : this.metadata.entrySet()) {
			tempMap.put(entry.getKey(), entry.getValue());
		}
		return tempMap;
	}
}