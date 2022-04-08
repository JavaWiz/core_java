package com.javawiz.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class Person {
	private int id;
	private String name;
	private int age;
	private int weight;
	private Gender gender;
	public enum Gender { MALE, FEMALE };

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
}
