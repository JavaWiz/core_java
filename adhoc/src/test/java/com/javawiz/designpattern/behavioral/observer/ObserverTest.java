package com.javawiz.designpattern.behavioral.observer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ObserverTest {

	@Test
	public void testObservers() {
		NewsAgency observable = new NewsAgency();
		NewsChannel observer = new NewsChannel();

		observable.addObserver(observer);
		observable.setNews("news");
		assertEquals(observer.getNews(), "news");
	}
}
