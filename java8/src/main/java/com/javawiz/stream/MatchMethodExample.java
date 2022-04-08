package com.javawiz.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class MatchMethodExample {
    public static void main(String[] args) {
        List<String> names =
                Arrays.asList("Jon", "Ajeet", "Steve",
                        "Ajeet", "Jon", "Ajeet");

        List<String> emptyList = new ArrayList<>();

        Predicate<String> allMatch = name -> name.equals("Jon");
        Predicate<String> anyMatch = name -> name.equals("Ajeet");
        Predicate<String> noneMatch = name -> name.equals("Ranjan");

        System.out.println("allMatch Returned false, may not evaluate the predicate on all elements : "+names.stream().allMatch(allMatch));
        System.out.println("allMatch Returned true, as stream is empty : "+emptyList.stream().allMatch(allMatch));

        System.out.println("anyMatch Returned true, as it's got a match : "+names.stream().anyMatch(anyMatch));
        System.out.println("anyMatch Returned false, as stream is empty : "+emptyList.stream().anyMatch(anyMatch));

        System.out.println("noneMatch Returned false, as it did not get a match : "+names.stream().anyMatch(noneMatch));
        System.out.println("noneMatch Returned true : "+emptyList.stream().noneMatch(noneMatch));
    }
}
