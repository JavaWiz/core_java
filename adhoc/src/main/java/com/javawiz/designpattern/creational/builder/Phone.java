package com.javawiz.designpattern.creational.builder;

public class Phone {
	public enum PhoneType {
		ANDROID, 
		IPHONE
	};

	public enum OSType {
		MEDIATECH, 
		QUALCOMM
	};
	
	public enum ProcessorType{
		APPLE_A15_BIONIC, 
		DIMENSITY_9000, 
		SNAPDRAGON_8_GEN_1
	};
	
	private PhoneType phoneType;
	private OSType osType;
	private ProcessorType processorType;
	private int ramSize;

	public Phone(PhoneType phoneType, OSType osType, ProcessorType processorType, int ramSize) {
		this.phoneType = phoneType;
		this.osType = osType;
		this.processorType = processorType;
		this.ramSize = ramSize;
	}

	public PhoneType getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(PhoneType phoneType) {
		this.phoneType = phoneType;
	}

	public OSType getOsType() {
		return osType;
	}

	public void setOsType(OSType osType) {
		this.osType = osType;
	}

	public ProcessorType getProcessorType() {
		return processorType;
	}

	public void setProcessor(ProcessorType processorType) {
		this.processorType = processorType;
	}

	public int getRamSize() {
		return ramSize;
	}

	public void setRamSize(int ramSize) {
		this.ramSize = ramSize;
	}

	@Override
	public String toString() {
		return "Phone [phoneType=" + phoneType + ", osType=" + osType + ", ProcessorType=" + processorType + ", ramSize="
				+ ramSize + "]";
	}
}
