package com.javawiz.foreach;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class CounterExample {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        //As an alternative to sync hassling AtomicInteger one could use an integer array instead.
        // As long as the reference to the array does not get another array assigned (and that's the point)
        // it can be used as a final variable while the values of the fields can change arbitrarily.
        final int[] arrayCounter = {0};
        List<String> another = list.stream()
                .map(item -> item + arrayCounter[0]++)
                .collect(Collectors.toList());
        another.forEach(System.out::println);

        System.out.println("---------------------");
        //we can use AtomicInteger's incrementAndGet or (++i) and getAndIncrement or (i++) method on it.
        AtomicInteger atomicCounter = new AtomicInteger(0);
        List<String> other = list.stream().map(item -> item + atomicCounter.getAndIncrement())
                .collect(Collectors.toList());
        other.forEach(System.out::println);
        System.out.println("The lambda ran " + atomicCounter.get() + " times");
    }
}
