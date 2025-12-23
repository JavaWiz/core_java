package com.javawiz.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.DecimalFormat;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Comparable<Employee> {
	private int id;
	private String name;
	private Integer age;
	private double salary;
	private List<String> phoneNumbers;

	@Override
	public int compareTo(Employee o) {
		return this.getId() - o.getId();
	}

	@Override
	public String toString(){
		DecimalFormat dformat = new DecimalFormat(".##");
		return "Employee Name:"+this.name
				+ "  Age:"+this.age
				+ "  Salary:"+dformat.format(this.salary);
	}
}