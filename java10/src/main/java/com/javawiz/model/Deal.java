package com.javawiz.model;

import java.math.BigDecimal;
import java.time.LocalDate;

/** * Simple Java value class to represent a deal */
public class Deal {
	public enum Type {
		BOOK, ELECTRONIC, TRAVEL, COSMATIC, ACTIVITY,
	}

	private final String provider;
	private final Type type;
	private final BigDecimal price;
	private final BigDecimal discount;
	private final String title;
	private final LocalDate validity;

	public Deal(String provider, Type type, BigDecimal price, BigDecimal discount, String title, LocalDate validity) {
		this.provider = provider;
		this.type = type;
		this.price = price;
		this.discount = discount;
		this.title = title;
		this.validity = validity;
	}

	public String provider() {
		return provider;
	}

	public Type type() {
		return type;
	}

	public BigDecimal price() {
		return price;
	}

	public BigDecimal discount() {
		return discount;
	}

	public String title() {
		return title;
	}

	public LocalDate validity() {
		return validity;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(title).append(" from ").append(provider).append(", price : ").append(price)
				.append(", offer valid till ").append(validity).append(" category : ").append(type);
		return sb.toString();
	}
}
