package com.javawiz.calender;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateAndCalendar {
	public static void main(String[] argv) throws ParseException {

		// 1. Create a Date from String
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String dateInString = "22-01-2015";
		Date date = sdf.parse(dateInString);
		DateAndCalendar obj = new DateAndCalendar();

		// 2. Test - Convert Date to Calendar
		Calendar calendar = obj.dateToCalendar(date);
		System.out.println(calendar.getTime());

		// 3. Test - Convert Calendar to Date
		Date newDate = obj.calendarToDate(calendar);
		System.out.println(newDate);

	}

	// Convert Date to Calendar
	private Calendar dateToCalendar(Date date) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar;

	}

	// Convert Calendar to Date
	private Date calendarToDate(Calendar calendar) {
		return calendar.getTime();
	}
}
