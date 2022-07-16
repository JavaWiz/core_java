package com.javawiz.designpattern.creational.singleton;

public class SingletonLazyHolder {

    private SingletonLazyHolder() {
    }

    private static class LazyHolder {
        private static final SingletonLazyHolder INSTANCE = new SingletonLazyHolder();
    }

    public static SingletonLazyHolder getInstance(){
        return LazyHolder.INSTANCE;
    }
}