package com.javawiz.designpattern;

public class Singleton {

    private Singleton() {
    }

    private static class LazyHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance(){
        return LazyHolder.INSTANCE;
    }
}