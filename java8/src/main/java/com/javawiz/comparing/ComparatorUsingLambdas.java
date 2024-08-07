package com.javawiz.comparing;

import com.javawiz.model.TrainingCourses;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class ComparatorUsingLambdas {
	public static void main(String args[]) {
		// list of training courses, our target is to sort these courses
		// based upon their price or title
		List<TrainingCourses> onlineCourses = new ArrayList<>();
		onlineCourses.add(new TrainingCourses("Java", new BigDecimal("200")));
		onlineCourses.add(new TrainingCourses("Scala", new BigDecimal("300")));
		onlineCourses.add(new TrainingCourses("Spring", new BigDecimal("250")));
		onlineCourses.add(new TrainingCourses("NoSQL", new BigDecimal("310")));

		// Creating Comparator to compare Price of training courses
		final Comparator<TrainingCourses> PRICE_COMPARATOR = Comparator.comparing(TrainingCourses::price);

		// Comparator to compare title of courses
		final Comparator<TrainingCourses> TITLE_COMPARATOR = Comparator.comparing(TrainingCourses::title);

		// sorting objects using Comparator by price
		System.out.println("List of training courses, before sorting");
		System.out.println(onlineCourses);
		Collections.sort(onlineCourses, PRICE_COMPARATOR);
		System.out.println("After sorting by price, increasing order");
		System.out.println(onlineCourses);
		System.out.println("Sorting list by title ");
		Collections.sort(onlineCourses, TITLE_COMPARATOR);
		System.out.println(onlineCourses);

		// Now let's see how less code you need to write if you use
		// lambda expression from Java 8, in place of anonymous class
		// we don't need an extra line to declare comparator, we can
		// provide them in place to sort() method.
		System.out.println("Sorting objects in decreasing order of price, using lambdas");
		Collections.sort(onlineCourses, (c1, c2) -> c2.price().compareTo(c1.price()));
		System.out.println(onlineCourses);
		System.out.println("Sorting list in decreasing order of title, using lambdas");
		Collections.sort(onlineCourses, (c1, c2) -> c2.title().compareTo(c1.title()));
		System.out.println(onlineCourses);
	}
}
