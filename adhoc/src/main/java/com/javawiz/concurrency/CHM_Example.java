package com.javawiz.concurrency;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

public class CHM_Example {

    public static void main(String[] args) {
        Map<Integer, Integer> map = new ConcurrentHashMap<>();
        CountDownLatch latch = new CountDownLatch(10);
        // Adding elements to the ConcurrentHashMap
        for (int i = 0; i < 10; i++) {
            int threadId = i;
            new Thread(() -> {
                for(int j = 0; j < 100; j++) {
                    map.put(threadId * 100 +j, j);
                }
                latch.countDown();
            }).start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Final size: " + map.size());
    }
}
