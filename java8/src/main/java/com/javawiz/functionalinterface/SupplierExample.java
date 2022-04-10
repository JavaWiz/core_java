package com.javawiz.functionalinterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class SupplierExample {

	public static void main(String[] args) {
		Supplier<String> s = () -> "Hallo Javawiz. Welcome to this fucking IT world.";
		System.out.println(s.get());
		
		
		//List<String> list = List.of("I am Javawiz.", "How are you?");
		List<String> list = new ArrayList<>();
		
		System.out.println(list.stream().findAny().orElseGet(s));
	}
}
