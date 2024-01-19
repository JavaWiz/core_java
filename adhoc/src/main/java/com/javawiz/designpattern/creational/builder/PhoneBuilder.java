package com.javawiz.designpattern.creational.builder;

import com.javawiz.designpattern.creational.builder.Phone.OSType;
import com.javawiz.designpattern.creational.builder.Phone.PhoneType;
import com.javawiz.designpattern.creational.builder.Phone.ProcessorType;

public class PhoneBuilder {
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
