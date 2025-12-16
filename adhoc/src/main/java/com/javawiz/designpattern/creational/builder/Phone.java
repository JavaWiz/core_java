package com.javawiz.designpattern.creational.builder;

public class Phone {
	private final PhoneType phoneType;
	private final OSType osType;
	private final ProcessorType processorType;
	private final int ramSize;

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

	public Phone(PhoneType phoneType, OSType osType, ProcessorType processorType, int ramSize) {
		this.phoneType = phoneType;
		this.osType = osType;
		this.processorType = processorType;
		this.ramSize = ramSize;
	}

	public PhoneType getPhoneType() {
		return phoneType;
	}

	public OSType getOsType() {
		return osType;
	}

	public ProcessorType getProcessorType() {
		return processorType;
	}

	public int getRamSize() {
		return ramSize;
	}

	@Override
	public String toString() {
		return "Phone [phoneType=" + phoneType + ", osType=" + osType + ", ProcessorType=" + processorType + ", ramSize="
				+ ramSize + "]";
	}

	public static PhoneBuilder builder() {
		return new PhoneBuilder();
	}

	public static class PhoneBuilder {
		private PhoneType phoneType;
		private OSType osType;
		private ProcessorType processorType;
		private int ramSize;

		public PhoneBuilder setPhoneType(PhoneType phoneType) {
			this.phoneType = phoneType;
			return this;
		}

		public PhoneBuilder setOsType(OSType osType) {
			this.osType = osType;
			return this;
		}

		public PhoneBuilder setProcessorType(ProcessorType processorType) {
			this.processorType = processorType;
			return this;
		}

		public PhoneBuilder setRamSize(int ramSize) {
			this.ramSize = ramSize;
			return this;
		}

		public Phone build() {
			return new Phone(phoneType, osType, processorType, ramSize);
		}
	}
}
