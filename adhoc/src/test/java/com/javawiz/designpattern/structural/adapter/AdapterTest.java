package com.javawiz.designpattern.structural.adapter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AdapterTest {
	
	@Test
	public void whenConvertingMPHToKMPH_thenSuccessfullyConverted() {
	    Movable bugattiVeyron = new BugattiVeyron();
	    MovableAdapter bugattiVeyronAdapter = new MovableAdapterImpl(bugattiVeyron);
	 
	    assertEquals(bugattiVeyronAdapter.getSpeed(), 431.30312, 0.00001);
	}
}
