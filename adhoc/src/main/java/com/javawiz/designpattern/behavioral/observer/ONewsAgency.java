package com.javawiz.designpattern.behavioral.observer;

import java.util.Observable;

@SuppressWarnings("deprecation")
public class ONewsAgency extends Observable {
	private String news;

	public void setNews(String news) {
		this.news = news;
		setChanged();
		notifyObservers(news);
	}
}