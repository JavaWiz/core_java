package com.javawiz.designpattern.creational.singleton;

public class SingletonLazyHolder {

    private SingletonLazyHolder() {
    }
    
    /*
     * The ‘Inner Class’ Approach
     * In Java, class initialization is ‘on-demand’ & performed the first time the class is used.
     * Normally, this underlying behavior is of little interest.. But can we use it?
     * The approach here is to create a ‘holder’ as an inner class, which will statically initialize the singleton.
     * This pattern is known as the “initialization-on-demand holder” idiom.
     *
     * Calling getSingleton() references the inner class, triggering the JVM to load & initialize it.
     * This is thread-safe, since classloading uses locks.
     * For subsequent calls, the JVM resolves our already-loaded inner class & returns the existing singleton.  Thus — a cache.
     * And thanks to the magic of JVM optimizations, a very very efficient one.
     */

    private static class LazyHolder {
        private static final SingletonLazyHolder INSTANCE = new SingletonLazyHolder();
    }

    public static SingletonLazyHolder getInstance(){
        return LazyHolder.INSTANCE;
    }
}