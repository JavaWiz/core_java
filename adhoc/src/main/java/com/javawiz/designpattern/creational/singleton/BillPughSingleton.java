package com.javawiz.designpattern.creational.singleton;

/**
 * Bill Pugh Singleton Design Pattern Implementation
 *
 * This implementation uses a private static inner class to hold the singleton instance.
 * The instance is created only when the inner class is loaded, ensuring lazy initialization
 * and thread safety without requiring synchronized blocks.
 */
public class BillPughSingleton {
    // Private constructor to prevent external instantiation
    private BillPughSingleton() {}

    // Private static inner class that holds the singleton instance
    private static class SingletonHelper {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    // Public static method to provide global access to the instance
    public static BillPughSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
    
    // Example method
    public void showMessage() {
        System.out.println("Hello World! This is the single instance.");
    }

    public static void main(String[] args) {
        BillPughSingleton object1 = BillPughSingleton.getInstance();
        BillPughSingleton object2 = BillPughSingleton.getInstance();

        object1.showMessage();
        // Verify both references point to the same object in memory
        System.out.println(object1 == object2); // Output: true
    }
}