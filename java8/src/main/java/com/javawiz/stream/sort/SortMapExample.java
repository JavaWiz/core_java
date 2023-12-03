package com.javawiz.stream.sort;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortMapExample {
    public static void main(String[] args) {
        sortByKeyJava8Stream(getUnSortedMap());

        Comparator<Map.Entry<String, Integer>> keyComparator = (o1, o2) -> o1.getKey().compareTo(o2.getKey());
        Comparator<Map.Entry<String, Integer>> valueComparator = (o1, o2) -> o1.getValue() - o2.getValue();
        Comparator<Map.Entry<String, Integer>> java8KeyComparator = Map.Entry.comparingByKey();
        Comparator<Map.Entry<String, Integer>> java8ValueComparator = Map.Entry.comparingByValue();

        System.out.println("Sorted Map by key : \n" + sort(getUnSortedMap(), keyComparator)+"\n");
        System.out.println("Sorted Map by value : \n" + sort(getUnSortedMap(), valueComparator)+"\n");
        System.out.println("Sorted Map by Java8 Key Comparator : \n" + sort(getUnSortedMap(), java8KeyComparator)+"\n");
        System.out.println("Sorted Map by Java8 Value Comparator : \n" + sort(getUnSortedMap(), java8ValueComparator)+"\n");
    }

    private static <K, V> Map<K, V> sort(Map<K, V> unSortedMap, Comparator<Map.Entry<K, V>> comparator) {
        return unSortedMap.entrySet().stream().sorted(comparator).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }

    private static void sortByKeyJava8Stream(Map<String, Integer> unSortedMap){

        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        unSortedMap.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));

        System.out.println("Sorted Map   : " + sortedMap);

        LinkedHashMap<String, Integer> reverseSortedMap = new LinkedHashMap<>();
        unSortedMap.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));

        System.out.println("Reverse Sorted Map   : " + reverseSortedMap+"\n");
    }
    
    private static Map<String, Integer> getUnSortedMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("alex", 1);
        map.put("charles", 4);
        map.put("david", 2);
        map.put("brian", 5);
        map.put("elle", 3);
        return map;
    }
}
