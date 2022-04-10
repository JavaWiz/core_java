package com.javawiz.supplier;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class SupplierTwo<T> {

    public static void main(String[] args) {

        SupplierTwo<String> obj = new SupplierTwo<>();

        List<String> list = obj.supplier().get();

    }

    public Supplier<List<T>> supplier() {
        // lambda
        // return () -> new ArrayList<>();
        // constructor reference
        return ArrayList::new;
    }
}