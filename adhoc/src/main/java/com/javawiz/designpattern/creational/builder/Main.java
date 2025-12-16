package com.javawiz.designpattern.creational.builder;

import com.javawiz.designpattern.creational.builder.Phone.OSType;
import com.javawiz.designpattern.creational.builder.Phone.PhoneType;
import com.javawiz.designpattern.creational.builder.Phone.ProcessorType;

public class Main {

	public static void main(String[] args) {

		Phone phone = Phone.builder()
			.setOsType(OSType.MEDIATECH)
			.setPhoneType(PhoneType.IPHONE)
			.setProcessorType(ProcessorType.APPLE_A15_BIONIC)
			.setRamSize(512)
			.build();
		System.out.println(phone);
	}
}
