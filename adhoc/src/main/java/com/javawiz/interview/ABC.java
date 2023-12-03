package com.javawiz.interview;

import java.util.ArrayList;
import java.util.List;

public final class ABC{
	private final String name;
	private final int age;
	private final List<Long> contact;
	
	public ABC(String name, int age, List<Long> copycontact){
		this.name = name;
		this.age = age;
		contact = new ArrayList<>(copycontact);
	}
	
	List<Long> getContact(){
		return contact;
	}
}