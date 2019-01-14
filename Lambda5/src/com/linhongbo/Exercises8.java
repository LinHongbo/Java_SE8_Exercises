package com.linhongbo;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

public class Exercises8 {

	public static void main(String[] args) {
		Set<String> set = ZoneId.getAvailableZoneIds();
		set.stream()
				.map(item -> ZonedDateTime.ofInstant(Instant.now(), ZoneId
						.of(item))).forEach((item -> {
					System.out.println(item.getZone().getId());
					System.out.println(item.getOffset().getId());
				}));
	}

}
