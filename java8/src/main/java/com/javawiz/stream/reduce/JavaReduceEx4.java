package com.javawiz.stream.reduce;

import com.javawiz.data.CollectionDB;
import com.javawiz.model.Person;

import java.util.List;
import java.util.OptionalInt;

/**
 * Collection Of People
 * Select those who are male
 * Choose who is the heaviest in the collection
 * select * from people where 
 */
public class JavaReduceEx4 {
    public static void main(String[] args) {
        List<Person> list = CollectionDB.getAllPersons();
        
        int higestWeight = 0;
        for (Person person: list) {
            if(person.getGender() == Person.Gender.MALE){
                int weight = person.getWeight();
                higestWeight = Math.max(higestWeight, weight);
            }
        }
        
        System.out.println(higestWeight);

        OptionalInt max = list.stream()
        		.filter(p -> p.getGender() == Person.Gender.MALE)
        		.mapToInt(Person::getWeight)
        		.reduce(Integer::max);
               //.max();
        System.out.println(max.getAsInt());
    }
}
