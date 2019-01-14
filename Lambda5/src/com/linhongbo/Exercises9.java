package com.linhongbo;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

public class Exercises9 {
	public static void main(String[] args) {
		Set<String> set = ZoneId.getAvailableZoneIds();
		set.stream()
				.map(item -> ZonedDateTime.ofInstant(Instant.now(), ZoneId
						.of(item))).filter(item -> {
					String id = item.getOffset().getId();
					String mintue = id.substring(id.indexOf(":") + 1);
					return !mintue.equals("00") && !mintue.equals("Z");
				}).forEach((item -> {
					System.out.println(item.getZone().getId());
				}));
	}
}