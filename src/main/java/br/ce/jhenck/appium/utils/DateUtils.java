package br.ce.jhenck.appium.utils;

import java.time.Month;

public class DateUtils {
	
	public static int getMonthNumber(String monthName) {
	    return Month.valueOf(monthName.toUpperCase()).getValue();
	}
}
