package com.javawiz.stream.collect;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.javawiz.model.Hosting;

public class ConvertListToMap {
	public static void main(String[] args) {
		List<Hosting> list = new ArrayList<>();
		list.add(new Hosting(1, "liquidweb.com", 80000));
		list.add(new Hosting(2, "linode.com", 90000));
		list.add(new Hosting(3, "digitalocean.com", 120000));
		list.add(new Hosting(4, "aws.amazon.com", 200000));
		list.add(new Hosting(5, "javawiz.com", 1));

		listToMap(list);
		System.out.println("++++++++++++ With Duplicate Key +++++++++++++++++");
		listToMapWithDuplicateKey(list);
		System.out.println("++++++++++++ Order Map +++++++++++++++++");
        orderMap(list);
	}

	public static void orderMap(List<Hosting> list) {
		list.add(new Hosting(6, "linode.com", 100000));
		Map<String, Long> result1 = list.stream()
                .sorted(Comparator.comparingLong(Hosting::getWebsites).reversed())
                .collect(
                        Collectors.toMap(
                                Hosting::getName, Hosting::getWebsites, // key = name, value = websites
                                (oldValue, newValue) -> oldValue,       // if same key, take the old key
                                LinkedHashMap::new                      // returns a LinkedHashMap, keep order
                        ));

        System.out.println("Result 1 : " + result1);
	}

	// Create a list of the Hosting objects, and uses Collectors.toMap to convert it
	// into a Map.
	public static void listToMap(List<Hosting> list) {
		// key = id, value - web sites
		Map<Integer, String> result1 = list.stream().collect(Collectors.toMap(Hosting::getId, Hosting::getName));

		System.out.println("Result 1 : " + result1);

		// key = name, value - web sites
		Map<String, Long> result2 = list.stream().collect(Collectors.toMap(Hosting::getName, Hosting::getWebsites));

		System.out.println("Result 2 : " + result2);

		// Same with result1, just different syntax
		// key = id, value = name
		Map<Integer, String> result3 = list.stream().collect(Collectors.toMap(x -> x.getId(), x -> x.getName()));

		System.out.println("Result 3 : " + result3);
	}

	public static void listToMapWithDuplicateKey(List<Hosting> list) {

		list.add(new Hosting(6, "linode.com", 100000)); // new line

		// key = name, value - websites , but the key 'linode' is duplicated!?
		//Map<String, Long> result1 = list.stream().collect(Collectors.toMap(Hosting::getName, Hosting::getWebsites));
		
		//Exception in thread "main" java.lang.IllegalStateException: Duplicate key 90000
		// To solve the duplicated key issue above, pass in the third mergeFunction argument like below
		Map<String, Long> result1 = list.stream()
				.collect(Collectors.toMap(Hosting::getName, Hosting::getWebsites, (oldValue, newValue) -> oldValue));
		
		//(oldValue, newValue) -> oldValue ==> If the key is duplicated, do you prefer oldKey or newKey?
		

		System.out.println("Result 1 : " + result1);
	}
}
