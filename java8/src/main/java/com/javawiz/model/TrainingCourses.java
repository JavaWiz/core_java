package com.javawiz.model;

import java.math.BigDecimal;

public class TrainingCourses {
	private final String title;
	private final BigDecimal price;

	public TrainingCourses(String title, BigDecimal price) {
		super();
		this.title = title;
		this.price = price;
	}

	public String title() {
		return title;
	}

	public BigDecimal price() {
		return price;
	}

	@Override
	public String toString() {
		return String.format("%s : %s", title, price);
	}
}
