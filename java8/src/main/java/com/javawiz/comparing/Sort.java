package com.javawiz.comparing;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Sort {
	public static void main(String[] args) {
		List<String> cities = Arrays.asList("Milan", "london", "San Francisco", "Tokyo", "new Delhi");
		System.out.println(cities);

		cities.sort(String.CASE_INSENSITIVE_ORDER);
		System.out.println(cities);

		cities.sort(Comparator.naturalOrder());
		System.out.println(cities);
	}
}
