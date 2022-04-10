package com.javawiz.comparing;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;


public class SortMapByKeyValueJava8 {

	public static void main(String[] args) {
		User user1 = new User(100, "Ranjan");
		User user2 = new User(104, "John");
		User user3 = new User(102, "Ace");
		User user4 = new User(103, "Keith");
		
		Employee emp1 = new Employee("Ranjan", 35, 40000.00, 992255140);
		Employee emp2 = new Employee("John", 25, 30000.00, 992255110);
		Employee emp3 = new Employee("Ace", 45, 20000.00, 992255120);
		Employee emp4 = new Employee("Keith", 35, 40000.00, 992255130);
		
		Map<User, Employee> map = new HashMap<>();
		map.put(user1, emp1);
		map.put(user2, emp2);
		map.put(user3, emp3);
		map.put(user4, emp4);
		
		
		
		// sort by user
		System.out.println("############### sort by user key ###############");
		sortByKey(map).forEach((k,v) -> System.out.println(k +":"+v)); 
		System.out.println("############## sort by employee value ###############");
		//sort by employee
		sortByValue1stWay(map).forEach((k,v) -> System.out.println(k +":"+v)); 
	}

	public static Map<User, Employee> sortByValue1stWay(Map<User, Employee> map) {
		Map<User, Employee> result = new LinkedHashMap<>(); 
		List<Entry<User, Employee>> list = new ArrayList<>(map.entrySet());
		
		Collections.sort(list, (o1, o2) -> o1.getValue().compareTo(o2.getValue()));
		
		for (Entry<User, Employee> entry : list) {
			result.put(entry.getKey(), entry.getValue());
		}
		return result;
	}
	
	public static Map<User, Employee> sortByValue2ndWay(Map<User, Employee> map) {
		Comparator<Entry<User, Employee>> value = Entry.<User, Employee>comparingByValue();
		return map.entrySet().stream()
				.sorted(value)
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
	}
	
	/*
	 * sorted() method takes Comparator as an argument, 
	 * making it possible to sort a map with any kind of value.
	 */
	public static Map<User, Employee> sortByValue(final Map<User, Employee> map) {
        return map.entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }

	private static Map<User, Employee> sortByKey(Map<User, Employee> map) {
		Map<User, Employee> result = new LinkedHashMap<>();
		Comparator<Entry<User, Employee>> comparator = Entry.comparingByKey();
		map.entrySet().stream().sorted(comparator)
				.forEachOrdered(x -> result.put(x.getKey(), x.getValue()));
		return result;
	}
}
