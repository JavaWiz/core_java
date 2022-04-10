package com.javawiz.comparing;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee implements Comparable<Employee> {
	private String name;
	private int age;
	private double salary;
	private long mobile;

	@Override
	public int compareTo(Employee o) {
		return this.name.compareTo(o.name);
	}
}