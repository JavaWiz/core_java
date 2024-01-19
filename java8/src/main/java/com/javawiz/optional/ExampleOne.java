package com.javawiz.optional;

import java.util.Optional;

public class ExampleOne {
    public static void main(String[] args) {
        changeCase("Anjan").ifPresent(System.out::println);
        System.out.println(changeCase("Ranjan").isPresent());
    }

    static Optional<String> changeCase(String word) {
        return Optional.ofNullable(word).filter(w -> w.startsWith("A")).map(String::toUpperCase);
    }
    
    //Before we got Optionals, the usual way to handle values was something like this:
    public static String beforeJava8(String word) {
    	if (word == null) {
    	    return "n/a";
    	}
    	return word.toUpperCase();
    }
    
    //With Optionals, we can compact this code into an easily-readable single-method call chain:
    public static String afterjava8(String word) {
		return Optional.ofNullable(word)
        .map(String::toUpperCase)
        .orElse("n/a");
    }
}
