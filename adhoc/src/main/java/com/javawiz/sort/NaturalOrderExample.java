package com.javawiz.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Student implements Comparable<Student> {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int compareTo(Student other) {
        // Natural order based on student ID (ascending)
        return Integer.compare(this.id, other.id); 
    }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "'}";
    }
}

public class NaturalOrderExample {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(3, "Charlie"));
        students.add(new Student(1, "Alice"));
        students.add(new Student(2, "Bob"));

        // Collections.sort() uses the natural ordering defined in compareTo()
        Collections.sort(students); 

        System.out.println(students); 
        // Output: [Student{id=1, name='Alice'}, Student{id=2, name='Bob'}, Student{id=3, name='Charlie'}]
    }
}
