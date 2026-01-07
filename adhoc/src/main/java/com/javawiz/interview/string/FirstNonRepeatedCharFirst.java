package com.javawiz.interview.string;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.apache.commons.collections4.map.HashedMap;

public class FirstNonRepeatedCharFirst {
	
	public static void main(String args[]) {

		String inputStr = "aaakabbbcddee";
		
		for (char i : inputStr.toCharArray()) {
			if (inputStr.indexOf(i) == inputStr.lastIndexOf(i)) {
				System.out.println("First non-repeating character is: " + i);
				break;
			}
		}

		System.out.println("====================================");
		Stream.of(inputStr.split(""))
		.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
		.entrySet().stream()
		.filter(map -> map.getValue() == 1)
		.findFirst()
		.ifPresent(map -> System.out.println("First non-repeating character is: " + map.getKey()));
		
		System.out.println("====================================");
		sample(inputStr);
	}
	
	
	//Before java8
	public static void sample(String str) {
		Map<Character, Integer> map = new HashedMap<>();
		for (char c : str.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		for(Entry<Character, Integer> entry: map.entrySet())
        {
            if(entry.getValue() == 1){
				System.out.println("First non-repeating character is: " + entry.getKey());
				break;
			}
        }
	}
}