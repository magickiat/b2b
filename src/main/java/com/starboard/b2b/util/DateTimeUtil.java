package com.starboard.b2b.util;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateTimeUtil {
	
	public static final Locale LOCALE = Locale.US;

	public static Calendar getCalendar() {
		return Calendar.getInstance(LOCALE);
	}

	public static Date getCurrentDate() {
		return getCalendar().getTime();
	}

	public static int getCurrentYear() {
		return getCalendar().get(Calendar.YEAR);
	}

	public static Date generateExpectShipDate() {
		Calendar now = getCalendar();

		int today = now.get(Calendar.DAY_OF_MONTH);

		if (today <= 15) {
			now.set(Calendar.DAY_OF_MONTH, 15);
			now.add(Calendar.MONTH, 2);
		} else if (today <= 20) {
			now.set(Calendar.DAY_OF_MONTH, 20);
		} else {
			now.set(Calendar.DAY_OF_MONTH, 15);
			now.add(Calendar.MONTH, 3);
		}

		return now.getTime();
	}

}
