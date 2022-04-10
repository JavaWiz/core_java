package com.javawiz.foreach;

import java.util.ArrayList;

public class ListForEach {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");
		
		list.forEach(System.out::println);
	}
}
