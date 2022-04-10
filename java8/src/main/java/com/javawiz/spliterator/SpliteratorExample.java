package com.javawiz.spliterator;

import com.javawiz.model.Person;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Spliterator;

public class SpliteratorExample {

	public static void main(String[] args) {
		Collection<Person> people = prepareData();
		
		Spliterator<Person> peopleSpliterator = people.spliterator();
		
		System.out.println(" " + peopleSpliterator.characteristics()); 
		System.out.println(" " + peopleSpliterator.estimateSize());
		
		Spliterator<Person> newPartition = peopleSpliterator.trySplit(); 
		System.out.println(" " + newPartition.estimateSize()); 
		System.out.println(" " + peopleSpliterator.estimateSize());
	}
	
	public static Collection<Person> prepareData(){
		Collection<Person> people = new ArrayList<Person>();
		Person p1 = new Person();
		p1.setName("Ranjan");
		people.add(p1);
		
		Person p2 = new Person();
		p2.setName("Rajesh");
		people.add(p2);
		
		Person p3 = new Person();
		p3.setName("Raman");
		people.add(p3);
		
		Person p4 = new Person();
		p4.setName("Rakesh");
		people.add(p4);
		return people;
	}
}
