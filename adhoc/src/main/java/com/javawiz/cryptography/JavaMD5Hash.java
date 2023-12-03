package com.javawiz.cryptography;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * The MD5 Message-Digest Algorithm is a widely used cryptographic hash function that produces a 128-bit (16-byte) hash value.
 * MD5 has been employed in a wide variety of security applications, and is also commonly used to check data integrity.
 * MD5 was designed by Ron Rivest in 1991 to replace an earlier hash function, MD4.
 * An MD5 hash is typically expressed as a 32-digit hexadecimal number.
 *
 * A cryptographic hash function is a hash function, that is,
 * an algorithm that takes an arbitrary block of data and returns a fixed-size bit string, the hash value,
 * such that an change to the data will change the hash value.
 * The data to be encoded is often called the “message,” and the hash value is sometimes called the message digest or simply digest.
 * Java security package java.security provides certain useful classes to generate Hash values.
 * Especially the class java.security.MessageDigest provides applications the functionality of a message digest algorithm,
 * such as MD5 or SHA. Below is an example of generating MD5 Hash value for any input in Java using java.security.MessageDigest.
 */

public class JavaMD5Hash {

	/*
	 * md5() method to get MD5 hash value of any input.
	 * In md5() method we used java.security.MessageDigest class’s object to generate Md5 hash.
	 * Note how we used java.math.BigInteger to convert the message digest into hex values of base 16.
	 * Alternately, we can also use Apache Commons Codec library to covert any string to Md5 hash.
	 * The commons-codec.jar contains class org.apache.commons.codec.digest.DigestUtils
	 * that can be used to generate MD5 hash.
	 */

	public static void main(String[] args) {

			String password = "MyPassword123";

			System.out.println("MD5 in hex: " + md5(password));

			
			System.out.println("MD5 in hex: " + md5(null));
			//null
			
			
			System.out.println("MD5 in hex: " 
				+ md5("The quick brown fox jumps over the lazy dog"));
			//= 9e107d9d372bb6826bd81d3542a419d6
	}
	
	
	public static String md5(String input) {
		
		String md5 = null;
		
		if(null == input) return null;
		
		try {
			
		//Create MessageDigest object for MD5
		MessageDigest digest = MessageDigest.getInstance("MD5");
		
		//Update input string in message digest
		digest.update(input.getBytes(), 0, input.length());

		//Converts message digest value in base 16 (hex) 
		md5 = new BigInteger(1, digest.digest()).toString(16);

		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();
		}
		return md5;
	}
}