package com.javawiz.optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Example {

	public static final List<String> NAMES = Arrays.asList("Rita", "Gita", "Nita", "Ritesh", "Nitesh", "Ganesh",
			"Yogen", "Pratam");

	public static void main(String[] args) {
		System.out.println("pickNameOldWay : "+pickNameOldWay(NAMES, "R"));
		
		System.out.println("pickNameIsPresent : "+pickNameIsPresent(NAMES, "G"));
		
		System.out.println("pickNameOrElse : "+pickNameOrElse(NAMES, "A"));
		
		System.out.println("pickNameOrElse : "+pickNameOrElse(NAMES, "G"));
		
		pickNameMap(NAMES, "G");
	}

	public static String pickNameOldWay(final List<String> names, final String startingLetter) {
		String searchedName = null;
		for (String name : names) {
			if (name.startsWith(startingLetter)) {
				searchedName = name;
				break;
			}
		}
		return searchedName != null ? searchedName : "No name found";
	}

	public static String pickNameIsPresent(final List<String> names, final String startingLetter) {
		final Optional<String> searchedName = names.stream().filter(name -> name.startsWith(startingLetter)).findFirst();
		return searchedName.isPresent() ? searchedName.get() : "No name found";
	}
	
	/*
	 * The Optional  class, however, supports other techniques that are superior to checking nulls. 
	 * The above code can be re-written as below with  orElse()  method as below.
	 * 
	 * The method orElse() is invoked with the condition "If X is null, populate X. Return X.".
	 * So that the default value can be set if the optional value is not present.
	 */
	
	public static String pickNameOrElse(final List<String> names, final String startingLetter) {
		final Optional<String> searchedName = names.stream().filter(name -> name.startsWith(startingLetter)).findFirst();
		return searchedName.orElse("No name found");
	}
	
	/*
	 * There is another method called the ifPresent(Function). 
	 * You can use this method to invoke an action and skip the null case completely. 
	 * For example, the program below prints a message in the case, if the condition is met.
	 */
	
	public static void pickNameOldWay1(final List<String> names, final String startingLetter) {
		String searchedName = null;
		for (String name : names) {
			if (name.startsWith(startingLetter)) {
				searchedName = name;
				break;
			}
		}
		if (searchedName != null) {
			postMessage(searchedName);
		}
	}

	public static void postMessage(final String name) {
		System.out.println(String.format("Congratulations, %s!", name));
	}
	
	//This can be re-written with ifPresent(), as shown below. in a more intuitive manner.
	public static void pickNameNewWay(final List<String> names, final String startingLetter) {
	   final Optional<String> searchedName = names.stream().filter(name -> name.startsWith(startingLetter)).findFirst();
	   searchedName.ifPresent(Example::postMessage);
	}
	
	/*
	 * If we want to throw an exception in case if no name is found, then it would be something like this.
	 */
	
	public String pickNameOldWay2(final List<String> names, final String startingLetter) {
		String searchedName = null;
		for (String name : names) {
			if (name.startsWith(startingLetter)) {
				searchedName = name;
				break;
			}
		}
		if (searchedName == null) {
			throw new RuntimeException("There is no name starting with letter.");
		}
		return searchedName;
	}
	
	//It can be meaningfully replaced with orElseThrow
	public String pickNameWOrElse(final List<String> names, final String startingLetter) {
		return names.stream().filter(name -> name.startsWith(startingLetter)).findFirst()
		.orElseThrow(() -> new RuntimeException("There is no name starting with letter."));
	}
	
	//Very often you need to apply some transformation on a value, but only if it’s not null (avoiding NullPointerException):
	
	public void pickNameOldWay3(final List<String> names, final String startingLetter) {
		String searchedName = null;
		for (String name : names) {
			if (name.startsWith(startingLetter)) {
				searchedName = name;
				break;
			}
		}
		
		if (searchedName != null) {
			String t = searchedName.toUpperCase();
		    System.out.println(t);
		}
	}
	
	public static void pickNameMap(final List<String> names, final String startingLetter) {
		names.stream()
		.filter(n -> n.startsWith(startingLetter))
		.findFirst()
		.map(String::toUpperCase)
	    .ifPresent(System.out::println);
	}
}
