package com.javawiz.algorithm;

import java.util.Scanner;

public class CheckNextSeat {
	public static void main(String[] args) {
		int totalSeats = 108;
		System.out.println("totalSeats :"+totalSeats);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter seat number :");
		int seatno = sc.nextInt();
		System.out.println("You Choose seat No.:"+seatno);
		int x = seatno%12;
		int y = seatno/12;
		int lb= 0, hb=0;
		if(seatno<=12) {
			lb= 0; hb=12;
			System.out.println("Your compartments is:"+ 1);
		}
		else {
			if(seatno>12 && x == 0) {
				lb = 12*(y-1);
				hb= 12*y;
				System.out.println("Your compartments is:"+ y);
			}else {
				lb = 12*y;
				hb = 12*(y+1);
				System.out.println("Your compartments is:"+ (y+1));
			}
		}
		if(seatno<lb+6) {
			int test = seatno-(lb+1);
			System.out.println("You are opposite to seat no."+(hb-test));
		}else {
			int test = (hb+1)-seatno;
			System.out.println("You are opposite to seat no."+(lb+test));
		}
		sc.close();
	}
}
