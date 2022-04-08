package com.javawiz.stream.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Requirement
 * Let's assume we have a list of names,
 * we want to convert list of string to upper case.
 */
public class SecondExample {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("Pankaj", "amit", "DAVID");
		beforeJava8(names);
		System.out.println("==========");
		inJava8(names);
	}

	private static void inJava8(List<String> names) {
		List<String> uppercaseList = names.stream().map(String::toUpperCase).collect(Collectors.toList());
		uppercaseList.forEach(System.out::println);
	}

	private static void beforeJava8(List<String> names) {
		List<String> upperCaseNames = new ArrayList<>();
		for (String n : names) {
			upperCaseNames.add(n.toUpperCase());
		}
		System.out.println(upperCaseNames);
	}
}
