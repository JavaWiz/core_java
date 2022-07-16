package com.javawiz.stream.shortcircuit;

import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * These terminal-short-circuiting methods can finish before traversing all the elements of the underlying stream.
 * A short-circuiting terminal operation, when operating on infinite input data source, may terminate in finite time.
 * Following are the terminal-short-circuiting methods defined in Stream interface.
 * Optional<T> findFirst()
 * Optional<T> findAny()
 * boolean anyMatch(Predicate<? super T> predicate)
 * boolean allMatch(Predicate<? super T> predicate)
 * boolean noneMatch(Predicate<? super T> predicate)
 */
public class TerminalShortCircuitExample {

	public static void main(String[] args) {
        IntStream stream = IntStream.of(1, 2, 3, 4, 5, 6);
        stream = stream.filter(i -> i % 3 == 0);
        OptionalInt opt1 = stream.findFirst();
        if (opt1.isPresent()) {
            System.out.println(opt1.getAsInt());
        }
        
        //Shortcut for above
        /*
        IntStream.of(1, 2, 3, 4, 5, 6)
        .filter(i -> i % 3 == 0)
        .findFirst()
        .ifPresent(System.out::println);
        */
        System.out.println("==============================");
        OptionalInt opt2 = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        .parallel()
        .filter(i -> i % 2 == 0)
        .findAny();
		if (opt2.isPresent()) {
			System.out.println(opt2.getAsInt());
		}
		
		System.out.println("===============anyMatch===============");
		//Tests whether any elements of this stream match the provided predicate. 
		//This terminal method will return as soon as it finds the match and 
		//will not traverse all the remaining elements to apply the predicate.
		//Following example prints 'true':

	    Stream<String> stream2 = Stream.of("one", "two","three", "four");
	    boolean match1 = stream2.peek(System.out::println)
	    .anyMatch(s -> s.contains("our"));
	    System.out.println(match1);
	    
	    System.out.println("==============allMatch================");
	    //Tests whether all elements match the provided predicate. 
	    //It may return early with false result when any element doesn't match first.
	    //Following examples outputs false because 'Three' doesn't start with a lower case, at that point short-circuiting happens.
	    Stream<String> stream3 = Stream.of("one", "two", "Three", "four");
	    boolean match2 = stream3
	    		.peek(System.out::println)
	    		.allMatch(s -> s.contains("our"));
	    System.out.println(match2);
	    
	    System.out.println("==============noneMatch================");
	    //Tests whether no elements of this stream match the provided predicate. 
  		//It may return early with false result when any element matches the provided predicate first.
  		//Following example will print 'true' because none of the elements start with an upper case.

  	  	Stream<String> stream4 = Stream.of("one", "two", "three", "four");
  	  	boolean match3 = stream4
  	  			.peek(System.out::println)
  	  			.noneMatch(s -> s.length() > 0 &&
  	                             Character.isUpperCase(s.charAt(0)));
  	  	System.out.println(match3);
	}
}
