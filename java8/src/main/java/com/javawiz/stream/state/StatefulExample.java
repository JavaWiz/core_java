package com.javawiz.stream.state;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class StatefulExample {

    public static void main (String[] args) {
        for (int i = 0; i < 5; i++) {

            Set<Integer> seen = new HashSet<>();
            IntStream stream = IntStream.of(1, 2, 1, 2, 3, 4, 4, 5);
            int sum = stream.parallel().map(
                e -> {
                      if (seen.add(e))
                          return e;
                      else
                          return 0;
                  }).sum();

            System.out.println(sum);

        }
    }
}