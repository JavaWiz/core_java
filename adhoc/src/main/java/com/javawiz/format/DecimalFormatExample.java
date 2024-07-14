package com.javawiz.format;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class DecimalFormatExample {
    public static void main(String[] args) {
        int number = 123456789;
        double decimalNumber = 123456789.47;

        // Create a DecimalFormat instance with a pattern
        DecimalFormat decimalFormat = new DecimalFormat("#,###");

        // Format the number
        String formattedNumber = decimalFormat.format(number);

        // Create a DecimalFormat instance for decimal numbers
        DecimalFormat decimalFormatWithDecimal = new DecimalFormat("#,###.###");

        // Format the decimal number
        String formattedDecimalNumber = decimalFormatWithDecimal.format(decimalNumber);

        // Print the formatted numbers
        System.out.println(formattedNumber);           // Output: 123,456,789
        System.out.println(formattedDecimalNumber);    // Output: 123,456,789.123


        // Example BigDecimal with two decimal places
        BigDecimal price = new BigDecimal("123.47");

        // Format BigDecimal to always show two decimal places
        DecimalFormat decimalFormat2 = new DecimalFormat("#,##0.00");
        String formattedPrice = decimalFormatWithDecimal.format(price);

        // Print the formatted price
        System.out.println(formattedPrice); // Output: 123.45
    }
}