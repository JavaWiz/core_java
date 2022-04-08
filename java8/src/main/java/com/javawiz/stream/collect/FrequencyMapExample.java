package com.javawiz.stream.collect;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FrequencyMapExample {

   public static void main(String[] args) {
      List<String> names =
          Arrays.asList("Jon", "Ajeet", "Steve",
             "Ajeet", "Jon", "Ajeet");
      System.out.println(frequencyMap(names.stream()));
      
      System.out.println("===========================");
      
      int[] array = {2, 5, 4, 4, 3, 4, 5};
      Map<Integer, Integer> feq = new HashMap<>();
      Arrays.stream(array).forEach(key -> {
    	  Integer value = feq.get(key);
    	  feq.put(key, value == null? 1 : value+1);
      });
      System.out.println(feq);
      
      System.out.println("===========================");
      
      System.out.println("Frequency map of an integer array or unboxed type -> "+ frequencyMap(Arrays.stream(array).boxed()));

      System.out.println("===========================");
      
      Character[] letters = {'a', 'b', 'b', 'c', 'c', 'c'};
      System.out.println(frequencyMap(Arrays.stream(letters)));
      
      System.out.println("===========================");

      System.out.println(frequencyMap("abccbabdaf".chars().mapToObj(c -> (char) c)));
   }

   private static <T> Map<T, Long> frequencyMap(Stream<T> elements){
      return elements.collect(
              Collectors.groupingBy(
                      Function.identity(),
                      HashMap::new, // but we can skip
                      Collectors.counting()
              )
      );
   }
}