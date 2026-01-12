package com.javawiz.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Demonstrates sorting a list of Student objects using Comparator.naturalOrder()
 * which relies on the natural ordering defined in the Student class.
 * The Student class implements Comparable to define its natural order based on student ID.
 * Using Comparator.naturalOrder() (Requires Comparable)
 * To use Comparator.naturalOrder(),
 * the Student class must explicitly declare that it implements Comparable<Student> and provide the compareTo method.
 * This method defines the "natural" behavior for all instances of Student.
 * You cannot force a natural ordering onto a class that doesn't implement the interface;
 * Comparator.naturalOrder() is merely a wrapper that calls the object's existing compareTo() method.
 */
public class NaturalOrderWithComparator {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(3, "Charlie"));
        students.add(new Student(1, "Alice"));
        students.add(new Student(2, "Bob"));

        // Use Comparator.naturalOrder() because the class implements Comparable
        students.sort(Comparator.naturalOrder());

        System.out.println(students);
        // Output: [Alice (101), Bob (102), Charlie (103)]
    }
}
