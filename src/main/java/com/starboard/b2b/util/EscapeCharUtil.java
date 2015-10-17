package com.starboard.b2b.util;

public class EscapeCharUtil {
	public String removeSpecialChar(String input) {
		String temp = "";
		if (input != null) {
			temp = input.replace("'", "").replace("\"", "").replace(" ", "_").replace(".", "_");
		}

		return temp;
	}
}
