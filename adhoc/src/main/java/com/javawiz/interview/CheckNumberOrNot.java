package com.javawiz.interview;

import java.util.regex.Pattern;

public class CheckNumberOrNot {

	public static void main(String[] args) {
		String str = "1.23 ";
		System.out.println(isNumericRE(str));
		
	}
	
	public static boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        Number d = Double.parseDouble(strNum);
	        System.out.println(d);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	
	public static boolean isNumericRE(String strNum) {
		Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)");
	    if (strNum == null) {
	        return false;
	    }
	    
	    return pattern.matcher(strNum.trim()).matches();
	}

}
