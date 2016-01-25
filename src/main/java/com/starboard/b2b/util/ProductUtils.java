package com.starboard.b2b.util;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

public class ProductUtils {
	private static final String NOSE_PROTECTOR = "NOSE PROTECTOR";

	public static boolean isWithnoseProduct(String name) {
		boolean isWithnose = false;

		if (StringUtils.isNotEmpty(name)) {
			isWithnose = name.contains(NOSE_PROTECTOR);
		}

		return isWithnose;
	}

	/**
	 * Product name must start with year (4 ditgit)
	 * 
	 * @param productName
	 * @return
	 */
	public static String getProductYear(String productName) {
		String year = "";

		if (StringUtils.isNotEmpty(productName) && productName.trim().length() > 4) {
			year = productName.trim().substring(0, 4);
			if (!NumberUtils.isDigits(year)) {
				year = "";
			}
		}
		return year;
	}

	public static String formatModelYear(String year) {
		return String.format("Model year %s", year);
	}

}
