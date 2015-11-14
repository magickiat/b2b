package com.starboard.b2b.util;

import java.util.Calendar;

import java.util.Date;
import java.util.Locale;

public class DateTimeUtil {

	public static Calendar getCalendar() {
		return Calendar.getInstance(Locale.US);
	}

	public static Date getCurrentDate() {
		return getCalendar().getTime();
	}
	
	public static int getCurrentYear(){
		return getCalendar().get(Calendar.YEAR);
	}

}
