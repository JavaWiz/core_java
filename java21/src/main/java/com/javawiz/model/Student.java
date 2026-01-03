package com.javawiz.model;

import java.util.List;
import lombok.Builder;

@Builder
public record Student (
    int id,
    String name,
    int age,
    List<Subject> subjects
) {
    public static List<Student> getStudents(){
        return List.of(
            new Student(1, "John", 20, List.of(
                new Subject("Math", 85),
                new Subject("Science", 90),
                new Subject("History", 78)
            )),
            new Student(2, "Alice", 22, List.of(
                new Subject("Math", 88),
                new Subject("Science", 92),
                new Subject("History", 80)
            )),
            new Student(3, "Bob", 21, List.of(
                new Subject("Math", 90),
                new Subject("Science", 85),
                new Subject("History", 88)
            ))
        );
    }
}