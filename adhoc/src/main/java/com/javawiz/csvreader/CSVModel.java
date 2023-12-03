package com.javawiz.csvreader;


public class CSVModel {
	private String itemNumber;

	public String getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(String itemNumber) {
		this.itemNumber = itemNumber;
	}

	@Override
	public String toString() {
		return "CSVModel [itemNumber=" + itemNumber + "]";
	}
}
