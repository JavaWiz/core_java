package com.javawiz.optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalMethodExample {
  
    public static void main(String[] args) {
        String str = "Ranjan";
        List<String> list = new ArrayList<>();
        list.add("Ranjan");
        list.add("Rejina");

        System.out.println("========== Optional.of ============");
        //Returns an Optional describing the given non-null value.
        //value – the value to describe, which must be non-null
        //NullPointerException – if value is null
        Optional<String> op = Optional.of(str);
        System.out.println(op);
        // get - If a value is present, returns the value, otherwise throws NoSuchElementException.
        System.out.println(op.get());
        System.out.println("========== Optional.ofNullable ============");
        //Returns an Optional describing the given value, if non-null, otherwise returns an empty Optional.
        //An Optional with a present value if the specified value is non-null, otherwise an empty Optional
        Optional<String> op1
            = Optional.ofNullable(str);
        // print value
        System.out.println("Optional 2: "
                + op1);
        Optional<List<String>> op2 = Optional.ofNullable(list);
        // print value
        System.out.println("Optional 2: " + op2.get());
        System.out.println("========== Optional.ifPresent ============");
        Optional.of(list).ifPresent(System.out::println);

        System.out.println("========== Optional.isPresent ============");
        System.out.println(Optional.of(list).isPresent());

        System.out.println("========== Optional.ifPresentOrElse java9 ============");
        //If a value is present, performs the given action with the value, otherwise performs the given empty-based action.
        Optional.ofNullable(list).ifPresentOrElse(
                value -> {
                    System.out.println("Value is present, it's: "+ value);
                    },
                () -> { System.out.println(
                        "Value is empty");
                });

        Optional.of(null)
        .ifPresentOrElse(
                (value)
                        -> { System.out.println(
                        "Value is present, its: "
                                + value); },
                ()
                        -> { System.out.println(
                        "Value is empty"); });
    }
} 