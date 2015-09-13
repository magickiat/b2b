package com.starboard.b2b.util;

import java.util.Calendar;

import java.util.Date;
import java.util.Locale;

public class DateTimeUtil {
	
	public static Date getCurrentDate() {
		return Calendar.getInstance(Locale.US).getTime();
	}
	
}
