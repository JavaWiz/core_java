package com.javawiz.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamSample {
	public static void main(String[] args) {

		String[] arr = new String[] { "a", "b", "c" };
		//Stream<String> stream = Arrays.stream(arr);
		//stream = Stream.of("a", "b", "c");

		//System.out.println(stream);

		List<String> list = Arrays.asList(arr);

		long count = list.stream().distinct().count();

		System.out.println(count);
		
		boolean isExist = list.stream().anyMatch(element -> element.contains("a"));
		
		System.out.println(isExist);
		
		
		ArrayList<String> texts = new ArrayList<>();
		texts.add("One");
		texts.add("OneAndOnly");
		texts.add("Derek");
		texts.add("Change");
		texts.add("factory");
		texts.add("justBefore");
		texts.add("Italy");
		texts.add("Italy");
		texts.add("Thursday");
		texts.add("");
		texts.add("");
		
		
		Stream<String> stream = texts.stream().filter(element -> element.contains("d"));
		
		System.out.println(stream);
		
		List<String> uris = new ArrayList<>();
		uris.add("C:\\My.txt");
		
		Stream<Integer> intstream = texts.stream().map(text -> text.length());
		
		System.out.println(intstream);

	}

	public boolean test(List<String> list) {

		for (String string : list) {
			if (string.contains("a")) {
				return true;
			}
		}
		
		return false;
	}
}
