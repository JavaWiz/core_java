package com.javawiz.stream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class SortByGenericExample {

    public static void main(String[] argv) {

        Map<String, Integer> unsortMap = new HashMap<>();
        unsortMap.put("z", 26);
        unsortMap.put("b", 2);
        unsortMap.put("c", 3);
        unsortMap.put("e", 7);
        unsortMap.put("y", 8);
        unsortMap.put("n", 14);
        unsortMap.put("a", 1);
        unsortMap.put("j", 10);
        unsortMap.put("d", 4);
        unsortMap.put("m", 2);
        unsortMap.put("f", 6);

        System.out.println("Original...");
        System.out.println(unsortMap);

        System.out.println("Sort By Key...");
        Map<String, Integer> resultKey = compareByKey(unsortMap);
        System.out.println(resultKey);

        System.out.println("Sort By Value...");
        Map<String, Integer> resultValue = compareByValue(unsortMap);
        System.out.println(resultValue);
    }

    public static <K extends Comparable<? super K>, V> Map<K, V> compareByKey(Map<K, V> map) {

        Map<K, V> result = new LinkedHashMap<>();
        map.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .forEachOrdered(x -> result.put(x.getKey(), x.getValue()));
        return result;
    }
    
  //Reference from java.util.Map source code, try dig inside, many generic examples.
    public static <K, V extends Comparable<? super V>> Map<K, V> compareByValue(Map<K, V> map) {
        Map<K, V> result = new LinkedHashMap<>();
        map.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .forEachOrdered(x -> result.put(x.getKey(), x.getValue()));
        return result;
    }
}