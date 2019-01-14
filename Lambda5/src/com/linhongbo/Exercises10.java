package com.linhongbo;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Exercises10 {

	public static void main(String[] args) {
		ZonedDateTime zonedDateTime = ZonedDateTime.now().withHour(15)
				.withMinute(5)
				.withZoneSameLocal(ZoneId.of("America/Los_Angeles"));
		ZonedDateTime reslut = zonedDateTime.plusHours(10).plusMinutes(50)
				.withZoneSameInstant(ZoneId.of("Europe/Paris"));
		ZonedDateTime reslut1 = zonedDateTime.plusHours(10).plusMinutes(50);
		System.out.println(reslut.format(DateTimeFormatter.ofPattern("hh:mm")));
		System.out
				.println(reslut1.format(DateTimeFormatter.ofPattern("hh:mm")));
	}

}
