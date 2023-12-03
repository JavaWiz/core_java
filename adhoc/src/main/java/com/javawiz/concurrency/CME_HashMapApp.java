package com.javawiz.concurrency;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CME_HashMapApp extends Thread {
	static Map<Integer, String> map = new  HashMap<>();
	
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
		System.out.println(map.put(100, "Ranjan"));
		System.out.println(map.put(101, "Rejina"));
		CME_HashMapApp t = new CME_HashMapApp();
		t.start();
		Set<Integer> set = map.keySet();
		synchronized(map) {
		Iterator<Integer> it = set.iterator();
		while(it.hasNext()) {
			Integer key = it.next();
			System.out.println(key+":"+ map.get(key));
			Thread.sleep(3000);
		}
		}
	}
}