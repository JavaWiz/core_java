package com.javawiz.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlTagExample {

	private static final Pattern TAG_REGEX = Pattern.compile("<[^>]*>");
	private static final Pattern TAG_REGEX1 = Pattern.compile("<(?:\"[^\"]*\"['\"]*|'[^']*'['\"]*|[^'\">])+>");

	public static void main(String[] args) {
		final String str = "<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while<par>";

		// Remove all HTML tags from a string
		Matcher m = TAG_REGEX.matcher(str);

		while (m.find()) {
			String text = m.replaceAll("\n");
			if(!text.isEmpty())
				System.out.println(m.replaceAll(""));
		}
	}

}
