package com.javawiz.other;

import java.util.*;
import java.util.stream.Collectors;

public class Assignment {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<String> list = new LinkedList<>();
		boolean flag = true;
		while (flag) {
			String s = sc.nextLine();
			if (s.contains("top")) {
				int top = findTop(s);
				System.out.println(calculateTop(top, list));
				list.clear();
			} else {
				list.add(s);
			}
		}
		sc.close();
	}

	private static int findTop(String s) {
		String top = s.replaceAll("[^0-9]", "");
		return Integer.valueOf(top);
	}

	private static String calculateTop(int top, List<String> list) {
		Map<String, Integer> map = new HashMap<>();
		for (String k : list) {
			Integer v = map.get(k);
			map.put(k, v == null ? v = 1 : v + 1);
		}

		String s = sortMap(map, top).keySet()
				.stream()
				.map(n -> n.toString())
				.collect(Collectors.joining( " "));
		return s;
	}

	private static Map<String, Integer> sortMap(Map<String, Integer> map, int top) {
		List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				if (o1.getValue() != o2.getValue())
					return (o2.getValue()).compareTo(o1.getValue());
				else
					return o1.getKey().compareTo(o2.getKey());
			}
		});

		HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
		for (Map.Entry<String, Integer> aa : list) {
			temp.put(aa.getKey(), aa.getValue());
			top--;
			if (top == 0)
				break;
		}
		return temp;
	}
}
