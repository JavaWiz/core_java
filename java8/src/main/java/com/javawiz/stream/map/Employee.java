package com.javawiz.stream.map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Employee {
	private int id;
	private String name;
	private double salary;
	private String designation;
}