package com.linhongbo;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class Exercises11 {
	public static void main(String[] args) {
		ZonedDateTime zonedDateTime1 = ZonedDateTime.now().withHour(14)
				.withMinute(5).withZoneSameLocal(ZoneId.of("Europe/Paris"));

		ZonedDateTime zonedDateTime2 = ZonedDateTime.now().withHour(16)
				.withMinute(40)
				.withZoneSameLocal(ZoneId.of("America/Los_Angeles"));

		long minute = zonedDateTime1.until(zonedDateTime2, ChronoUnit.MINUTES);
		System.out.println(minute);
		System.out.println(Duration.ofMinutes(minute));
	}
}
