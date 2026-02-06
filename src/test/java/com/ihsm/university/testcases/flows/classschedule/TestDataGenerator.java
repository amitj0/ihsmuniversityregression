package com.ihsm.university.testcases.flows.classschedule;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;

public class TestDataGenerator {
	
	private static final DateTimeFormatter FORMAT =
            DateTimeFormatter.ofPattern("ddMMyyyy");

	public static String getRandomDate(String start, String end) {

		LocalDate startDate = LocalDate.parse(start, FORMAT);
		LocalDate endDate = LocalDate.parse(end, FORMAT);

		long randomDay = ThreadLocalRandom.current().nextLong(startDate.toEpochDay(), endDate.toEpochDay() + 1);

		return LocalDate.ofEpochDay(randomDay).format(FORMAT);
	}

	// Generate random FROM and TO dates (TO always after FROM)
	public static String[] getRandomScheduleDates() {

		String startRange = "20012026"; // 20 Jan 2026
		String endRange = "20052026"; // 20 May 2026

		String fromDate = getRandomDate(startRange, endRange);
		String toDate = getRandomDate(fromDate, endRange);

		return new String[] { fromDate, toDate };
	}

}
