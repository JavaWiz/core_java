package com.javawiz.designpattern.creational.builder;

import com.javawiz.designpattern.creational.builder.Phone.OSType;
import com.javawiz.designpattern.creational.builder.Phone.PhoneType;
import com.javawiz.designpattern.creational.builder.Phone.ProcessorType;

public class Main {

	public static void main(String[] args) {
		Phone phone = new PhoneBuilder()
				.setOsType(OSType.MEDIATECH)
				.setPhoneType(PhoneType.ANDROID)
				.setProcessorType(ProcessorType.SNAPDRAGON_8_GEN_1)
				.setRamSize(256)
				.build();
		System.out.println(phone);
	}
}
