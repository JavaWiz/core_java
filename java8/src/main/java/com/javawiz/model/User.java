package com.javawiz.model;

import lombok.Data;

import java.util.Optional;

@Data
public class User {
    private String name;
    private Address address;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public static boolean isRealUser(User user) {
        return true;
    }

    public String getOrThrow() {
        String value = null;
        Optional<String> valueOpt = Optional.ofNullable(value);
        String result = valueOpt.orElseThrow(CustomException::new).toUpperCase();
        return result;
    }

    public boolean isLegalName(User user) {
        return user.getName().length() > 3 && user.getName().length() < 16;
    }
}