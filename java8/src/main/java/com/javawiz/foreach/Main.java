package com.javawiz.foreach;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		Map<String, Integer> maps = new HashMap<>();
		maps.put("A", 10);
		maps.put("B", 20);
		maps.put("C", 30);
		maps.put("D", 40);
		maps.put("E", 50);
		maps.put(null, 60);
		
		maps.forEach((k,v)->System.out.println("Item : " + k + " Count : " + v));
		
		maps.forEach((k,v)->{
			System.out.println("Item : " + k + " Count : " + v);
			if("E".equals(k)){
				System.out.println("Hello E");
			}
		});
		
		System.out.println("---------------------------------");
		List<String> list = new ArrayList<>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");
		
		list.forEach(item->System.out.println(item));
			
		list.forEach(item->{
			if("C".equals(item)){
				System.out.println(item);
			}
		});
			
		System.out.println("method reference");
		//Output : A,B,C,D,E
		list.forEach(System.out::println);
		
		System.out.println("Steam and filter");
		//Output : B
		list.stream()
			.filter(s->s.contains("B"))
			.forEach(System.out::println);
	}
}
