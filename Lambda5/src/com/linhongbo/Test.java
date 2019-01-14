package com.linhongbo;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.MonthDay;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		Instant instant1 = Instant.now();
		Thread.sleep(3000);
		Instant instant2 = Instant.now();
		System.out.println(Duration.between(instant1, instant2));

		LocalDate localDate = LocalDate.now();
		LocalDate localDate2 = LocalDate.of(2020, 12, 31);
		Period period = localDate.until(localDate2);
		System.out.println(period);

		localDate = LocalDate.of(2016, 1, 31).plusMonths(1);
		System.out.println(localDate);

		MonthDay monthDay = MonthDay.now();
		System.out.println(monthDay);

		// ZoneId.getAvailableZoneIds().forEach(System.out::println);
		ZoneId.of("Europe/Zagreb");
		ZonedDateTime zonedDateTime = ZonedDateTime.now();
		System.out.println(zonedDateTime.toInstant());

	}

}
