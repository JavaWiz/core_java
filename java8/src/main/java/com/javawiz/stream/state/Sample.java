package com.javawiz.stream.state;

import java.util.stream.IntStream;

public class Sample {
	private static int count = 0;
	public static void main(String[] args) {
		count = 0;
		int[] c= {0};
		int[] array = {7, 4, 5, 1, 3, 8, 2};
		IntStream stream = IntStream.of(array);
		
		stream.filter(i -> {
            boolean b = i % 2 == 0;
            if (b) {
            	//updating count hence making lambda stateful.
            	c[0]++;
                count++;
            }
            return b;
        }).
		forEach( a -> {
			System.out.println(a);
		});
		
		System.out.println("count :"+count);
		System.out.println(c.length);
	}
}
