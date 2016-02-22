package com.starboard.b2b.util;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.validator.routines.EmailValidator;

public class EmailUtils {

	private static final String SEPARATOR = ";|,| ";

	public static boolean validate(String emails) {
		if (StringUtils.isEmpty(emails)) {
			return false;
		}

		if (emails.contains(";") || emails.contains(",")) {
			String[] split = emails.split(SEPARATOR);
			for (String email : split) {
				if (!EmailValidator.getInstance().isValid(email)) {
					return false;
				}
			}
		} else {
			if (!EmailValidator.getInstance().isValid(emails)) {
				return false;
			}
		}

		return true;
	}

	public static String[] split(String emails) {
		if (StringUtils.isNotEmpty(emails)) {
			if (emails.contains(";") || emails.contains(",")) {
				return emails.split(emails);
			} else {
				return new String[] { emails.trim() };
			}
		}
		return null;
	}
}
