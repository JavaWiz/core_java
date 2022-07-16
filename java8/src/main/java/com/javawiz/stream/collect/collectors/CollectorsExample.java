package com.javawiz.stream.collect.collectors;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;

import static java.util.stream.Collectors.*;

public class CollectorsExample {
    public static void main(String[] args) {
        List<String> givenList = Arrays.asList("a", "bb", "ccc", "dd");

        DoubleSummaryStatistics result = givenList.stream()
                .collect(summarizingDouble(String::length));

        System.out.println(result.getAverage());
        System.out.println(result.getCount());
        System.out.println(result.getMax());
        System.out.println(result.getMin());
        System.out.println(result.getSum());
    }
}
