package com.javawiz.csvreader;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
	private static final String COMMA = ",";

	public static void main(String[] args) {
		String fileName = "stocks.csv";
		extracted(fileName);

		//processInputFile(fileName);
	}
	
	public static void stockFilter(String fileName) {
		try (Stream<String> lines = Files.lines(Paths.get(ClassLoader.getSystemResource(fileName).toURI()))) {
			List<List<String>> values = lines.map(line -> Arrays.asList(line.split(",")))
					.collect(Collectors.toList());
			values.forEach(System.out::println);
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
	}
	
	public static void extracted(String fileName) {
		try (Stream<String> lines = Files.lines(Paths.get(ClassLoader.getSystemResource(fileName).toURI()))) {
			List<List<String>> values = lines.map(line -> Arrays.asList(line.split(","))).collect(Collectors.toList());
			values.forEach(value -> System.out.println(value));
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
	}

	private static List<CSVModel> processInputFile(String fileName) {

		List<CSVModel> inputList = new ArrayList<CSVModel>();

		try(Stream<String> lines = Files.lines(Paths.get(ClassLoader.getSystemResource(fileName).toURI()))) {
			Function<String, CSVModel> mapToItem = (line) -> processFile(line);
			
			inputList = lines.map(mapToItem)
					.peek(System.out::println)
					.collect(Collectors.toList());

		} catch (IOException |URISyntaxException e) {

		}
		return inputList;
	}

	private static CSVModel processFile(String line) {
		String[] p = line.split(COMMA);// a CSV has comma separated lines

		CSVModel item = new CSVModel();
		item.setItemNumber(p[0]);
		if (p[3] != null && p[3].trim().length() > 0) {
		}
		return item;
	}
}
