package com.javawiz.stream.collect;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectorsToMapExample {
	
	public static void main(String[] args) {
		
		Integer[] array = {3, 1, 4, 5, 2};
		List<Integer> list = Arrays.asList(array);
		
		Function<Integer, Integer> keyMapper = i -> i;
		Function<Integer, Integer> valueMapper = i -> 2*i;
		Map<Integer, Integer> map = list.stream().collect(Collectors.toMap(keyMapper, valueMapper));
		System.out.println(map);
		
		
		Integer[] arrayWithDuplicate = {3, 5, 1, 4, 5, 2};
		List<Integer> list1 = Arrays.asList(arrayWithDuplicate);
		Map<Integer, Integer> map1 = list1.stream()
				.collect(
						Collectors.toMap(keyMapper, 
										 valueMapper, 
										 (oldValue, newValue) -> oldValue + newValue // merge function
						)
				);
		
		System.out.println(map1);
		
		Map<Integer, Integer> map2 = list1.stream()
				.collect(
						Collectors.toMap(keyMapper, 
										 valueMapper, 
										 (oldValue, newValue) -> oldValue + newValue, //merge function
										 LinkedHashMap::new //mapSupplier a function which returns a new, empty Map into which the results will be inserted
						)
				);
		System.out.println(map2);
	}

}
