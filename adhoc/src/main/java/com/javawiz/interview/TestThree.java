package com.javawiz.interview;

import java.util.ArrayList;
import java.util.List;

public class TestThree {

    public static void main(String[] args) {
        Sample sample = new Sample();
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Orange");
        list.add("banana");
        sample.setList(list);
        System.out.println(sample.getList());
    }
}
