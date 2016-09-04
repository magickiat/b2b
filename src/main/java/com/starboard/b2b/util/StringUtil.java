package com.starboard.b2b.util;

public class StringUtil {

	
	public static String removeSpecialChar(String data) {
		StringBuilder filename = new StringBuilder();

		for (char c : data.toCharArray()) {
			if (c == '.' || Character.isJavaIdentifierPart(c)) {
				filename.append(c);
			}
		}
		return filename.toString();
	}
}
