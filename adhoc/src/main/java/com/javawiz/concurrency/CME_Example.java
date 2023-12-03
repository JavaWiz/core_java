package com.javawiz.concurrency;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class CME_Example extends Thread {
	static ConcurrentMap<Integer, String> map = new  ConcurrentHashMap<>();
	
	@Override
	public void run() {
		System.out.println("We are updating the map ...");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		map.put(200, "Rehanshi");
	}
	
	public static void main(String[] args) throws InterruptedException {
		map.put(100, "Ranjan");
		map.put(101, "Rejina");
		CME_Example t = new CME_Example();
		t.start();
		Set<Integer> set = map.keySet();
		Iterator<Integer> it = set.iterator();
		while(it.hasNext()) {
			Integer key = it.next();
			System.out.println(key+":"+ map.get(key));
			Thread.sleep(3000);
		}
	}
}