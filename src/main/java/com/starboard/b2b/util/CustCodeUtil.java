package com.starboard.b2b.util;

import org.apache.commons.lang.StringUtils;

public class CustCodeUtil {
	public static String getCustCodeWithoutCurrency(String original) {
		String newCustCode = "";
		if (StringUtils.isNotEmpty(original) && original.contains("-")) {
			newCustCode = original.substring(0, original.lastIndexOf("-"));
		}
		return newCustCode;
	}
}
