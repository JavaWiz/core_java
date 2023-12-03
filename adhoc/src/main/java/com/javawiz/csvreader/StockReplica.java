package com.javawiz.csvreader;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class StockReplica {
	private String stockName;
	private String sector;
	private Double value;
	private Double oneMonthChange;
	private Double percentageOfTotalHolding;
	private Double highestHolding;
	private Double lowestHolding;
	private String quantity;
	private String mfHouse;
	@Override
	public String toString() {
		return "('"+ stockName + "', '" 
				+ sector + "', " 
				+ value + ", "
				+ oneMonthChange + ", " 
				+ percentageOfTotalHolding + ", "
				+ highestHolding + ", " 
				+ lowestHolding + ", '" 
				+ quantity + "', '"
				+ mfHouse + "')";
	}
}
