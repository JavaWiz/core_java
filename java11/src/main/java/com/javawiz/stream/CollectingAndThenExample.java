package com.javawiz.stream;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectingAndThenExample {

    public static void main(String[] args) {
        // Create an Immutable List
        List<String> lt
            = Stream
            .of("GEEKS", "For", "GEEKS", null)
                //.collect(Collectors.toUnmodifiableList());// throw NPE in case when we have null in list
            .collect(Collectors
                         .collectingAndThen(
                             Collectors.toList(),
                             Collections::<String> unmodifiableList));
        System.out.println(lt);

        // Create an Immutable Set
        Set<String> st
            = Stream
            .of("GEEKS", "FOR", "GEEKS")
            .collect(
                Collectors
                    .collectingAndThen(Collectors.toSet(),
                                       Collections::<String>
                                           unmodifiableSet));
        System.out.println(st);

        // Create an Immutable Map
        Map<String, String> mp
            = Stream
            .of(new String[][] {
                { "1", "Geeks" },
                { "2", "For" },
                { "3", "Geeks" } })
            .collect(
                Collectors
                    .collectingAndThen(
                        Collectors.toMap(p -> p[0], p -> p[1]),
                        Collections::<String, String>
                            unmodifiableMap));
        System.out.println(mp);
    }
}
