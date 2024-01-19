package com.javawiz.interview;

import java.util.Map.Entry;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.apache.commons.collections4.map.HashedMap;

public class FirstNonRepeatedCharFirst {
	
	public static void main(String args[]) {

		String inputStr = "aaaabbbcddee";
		
		for (char i : inputStr.toCharArray()) {
			if (inputStr.indexOf(i) == inputStr.lastIndexOf(i)) {
				System.out.println("First non-repeating character is: " + i);
				break;
			}
		}
		System.out.println("====================================");
		char[] ch = inputStr.toCharArray();
		Predicate<Character> p = (i) -> inputStr.indexOf(i) == inputStr.lastIndexOf(i);
		Stream<Character> cStream = IntStream.range(0, ch.length).mapToObj(i -> ch[i]);
		cStream.filter(p).findFirst().ifPresent(data -> System.out.println("First non-repeating character is: " + data));
		
		System.out.println("====================================");
		Predicate<String> ps =  str -> inputStr.indexOf(str) == inputStr.lastIndexOf(str);
		Stream.of(inputStr.split(""))
		.filter(ps)
		.findFirst()
		.ifPresent(data -> System.out.println("First non-repeating character is: " + data));
		
		System.out.println("====================================");
		Stream.of(inputStr.split(""))
		.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
		.entrySet()
		.stream()
		.filter(map -> map.getValue() == 1)
		.findFirst()
		.ifPresent(map -> System.out.println("First non-repeating character is: " + map.getKey()));
		
		System.out.println("====================================");
		sample(inputStr);
	}
	
	
	//Before java8
	public static void sample(String str) {
		char[] charray = str.toCharArray();
		HashedMap<Character, Integer> map = new HashedMap<>();
		for (int i = 0; i < charray.length; i++) {
			Character key = str.charAt(i);
			Integer value  = map.get(key);
			map.put(key, value == null ? 1 : value+1);
		}
		System.out.println(map);
		for(Entry<Character, Integer> entry: map.entrySet())
        {
            if(entry.getValue() == 1)
            	 System.out.println("First non-repeating character is: " + entry.getKey());
        }
	}
}