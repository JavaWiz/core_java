package com.javawiz.lambda;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person implements Comparable <Person>{
	
	private String firstName;
    private String lastName;
    private int age;

	@Override
	public int compareTo(Person o) {
		return this.age - o.getAge();
	}
}