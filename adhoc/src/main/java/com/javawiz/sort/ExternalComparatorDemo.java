package com.javawiz.sort;

import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class StudentWithoutComparable {
    String name;
    int rollNumber;

    public StudentWithoutComparable(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }
    
    // Override toString for easy printing
    @Override
    public String toString() {
        return name + " (" + rollNumber + ")";
    }
}

public class ExternalComparatorDemo {
    public static void main(String[] args) {
        List<StudentWithoutComparable> students = new ArrayList<>();
        students.add(new StudentWithoutComparable("Charlie", 103));
        students.add(new StudentWithoutComparable("Alice", 101));
        students.add(new StudentWithoutComparable("Bob", 102));

        // Define a Comparator for Student based on rollNumber
        Comparator<StudentWithoutComparable> rollNumberComparator = new Comparator<>() {
            @Override
            public int compare(StudentWithoutComparable s1, StudentWithoutComparable s2) {
                return Integer.compare(s1.rollNumber, s2.rollNumber);
                // Alternative using Java 8 method reference:
                // return Comparator.comparingInt(s -> s.rollNumber).compare(s1, s2);
            }
        };

        // Sort using the external Comparator
        Collections.sort(students, rollNumberComparator);

        System.out.println(students);
        // Output: [Alice (101), Bob (102), Charlie (103)]
    }
}
