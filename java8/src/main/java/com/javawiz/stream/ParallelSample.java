package com.javawiz.stream;

import java.util.Arrays;
import java.util.List;

public class ParallelSample {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(8,2,3,4,5);
        list.stream().parallel().map(ParallelSample::transform).forEach(System.out::println);
        list.parallelStream().map(ParallelSample::transform).forEach(System.out::println);
    }

    private static Integer transform(Integer number) {
        System.out.println(number+ "\nThread -> "+Thread.currentThread());
        return number;
    }
}
