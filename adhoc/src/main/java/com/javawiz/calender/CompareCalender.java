package com.javawiz.calender;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CompareCalender {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		// if date coming in string format like this from service
		String OPC = "28-02-2017";
		String OCB = "01-03-2017";
		
		Date OPC_date = sdf.parse(OPC);
		Date OCB_date = sdf.parse(OCB);
		
		boolean flag1 = todayDateBetween(OPC_date, OCB_date);
		boolean flag2 = todayDateBetweenRev(OPC_date, OCB_date);
		System.out.println(flag1);
		System.out.println(flag2);
	}
	// this logic will be wrong bcoz today has time
	private static boolean todayDateBetween(Date oPC_date, Date oCB_date) {
		System.out.println( oPC_date );
		System.out.println( oCB_date );
		Date today = new Date();
		System.out.println( today );
		System.out.println(oPC_date.compareTo(today)); // -1 as today > oPC_date
		System.out.println(today.compareTo(oCB_date)); // -1 as today < oCB_date
		if(oPC_date.compareTo(today) == -1 && today.compareTo(oCB_date) == -1)
			return true;
		return false;
	}
	
	private static boolean todayDateBetweenRev(Date oPC_date, Date oCB_date){
		System.out.println( oPC_date );
		System.out.println( oCB_date );
		
		Date today = new Date();
		
		Calendar calendar = Calendar.getInstance();
	    calendar.setTime( today );
	    calendar.set(Calendar.HOUR_OF_DAY, 0);
	    calendar.set(Calendar.MINUTE, 0);
	    calendar.set(Calendar.SECOND, 0);
	    calendar.set(Calendar.MILLISECOND, 0);

	    today = calendar.getTime();
		
		System.out.println( today );
		System.out.println(oPC_date.compareTo(today)); // -1 as today > oPC_date
		System.out.println(today.compareTo(oCB_date)); // -1 as today < oCB_date
		if(oPC_date.compareTo(today) == -1 && today.compareTo(oCB_date) == -1)
			return true;
		return false;
	}
}
