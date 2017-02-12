package sandeep.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TimeUtils {

	private TimeUtils() {

	}

	public static Date getFutureTime(Date initialTime, long millsToAdd) {
		Calendar cal = GregorianCalendar.getInstance();
		cal.setTimeInMillis(initialTime.getTime() + millsToAdd);
		return cal.getTime();
	}
}
