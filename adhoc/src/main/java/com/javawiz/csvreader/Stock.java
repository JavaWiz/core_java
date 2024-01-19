package com.javawiz.csvreader;

import lombok.Data;

@Data
public class Stock {
	private String stockName;
	private String sector;
	private String value;
	private String oneMonthChange;
	private String percentageOfTotalHolding;
	private String highestHolding;
	private String lowestHolding;
	private String quantity;
	private String mfHouse;
}
