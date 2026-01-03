package com.javawiz.format;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
 
class GFG {
    public static void main (String[] args) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
        Date date1 = simpleDateFormat.parse("2022-12-06");
        Date date2 = simpleDateFormat.parse("2022-12-05");
 
        System.out.println(date1.before(date2));
        System.out.println(date1.equals(date2));
        System.out.println(date1.after(date2));
        System.out.println(date1.before(new Date()));
    }
}