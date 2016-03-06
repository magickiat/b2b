package com.starboard.b2b.util;

import org.apache.commons.lang.StringUtils;

public class CurrencyUtils {
	public static String parseCurrencyB2BToAX(String currency, String category) {
		String result = currency;
		if (StringUtils.isEmpty(currency)) {
			result = "";
		} else if ("USD".equalsIgnoreCase(currency)) {
			result = "USS";
		} else if ("EUR".equalsIgnoreCase(currency)) {
			if ("SW".equalsIgnoreCase(category))
				result = "EUR";
			else
				result = "EUS";
		} else if ("AUD".equalsIgnoreCase(currency)) {
			result = "AUS";
		} else if ("GBP".equalsIgnoreCase(currency)) {
			result = "GBS";
		} else if ("THB".equalsIgnoreCase(currency)) {
			result = "THB";
		}
		return result;
	}

	public static String parseCurrencyAXToB2B(String currency) {
		String result = currency;
		if (StringUtils.isEmpty(currency)) {
			result = "";
		} else if ("USS".equalsIgnoreCase(currency)) {
			result = "USD";
		} else if ("EUR".equalsIgnoreCase(currency) || "EUS".equalsIgnoreCase(currency)) {
			result = "EUR";
		} else if ("AUS".equalsIgnoreCase(currency)) {
			result = "AUD";
		} else if ("GBS".equalsIgnoreCase(currency)) {
			result = "GBP";
		} else if ("THB".equalsIgnoreCase(currency)) {
			result = "THB";
		}
		return result;
	}
}
