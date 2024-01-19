package com.javawiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sample {

    public static void main(String[] args) {
        List<String> abc = new ArrayList<>(get());
        abc.add("def");
        System.out.println(new ArrayList<>(get()).add("def"));
    }

    public static List<String> get(){
        return List.of("abc","bcd");
    }

}
