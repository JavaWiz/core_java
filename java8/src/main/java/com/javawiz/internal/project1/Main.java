package com.javawiz.internal.project1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> list1 = new ArrayList<>();
        list1.add(new User(1, "Alice"));
        list1.add(new User(2, "Bob"));
        list1.add(new User(3, "Charlie"));

        List<User> list2 = new ArrayList<>();
        list2.add(new User(2, "Bob"));
        list2.add(new User(3, "Charlie"));
        list2.add(new User(4, "David"));

        List<User> added = new ArrayList<>();
        List<User> removed = new ArrayList<>();

        // Find added elements
        for (User user : list2) {
            if (!list1.contains(user)) {
                added.add(user);
            }
        }

        // Find removed elements
        for (User user : list1) {
            if (!list2.contains(user)) {
                removed.add(user);
            }
        }

        System.out.println("Added elements: " + added);
        System.out.println("Removed elements: " + removed);
    }
}