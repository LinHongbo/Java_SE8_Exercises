package com.linhongbo;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.function.Predicate;

public class Exercises3 {

	public static void main(String[] args) {
		LocalDate today = LocalDate.now();
		LocalDate next = today.with(next(locale -> locale.getDayOfWeek()
				.getValue() < 6));
		System.out.println(next);
	}

	private static TemporalAdjuster next(Predicate<LocalDate> predicate) {
		TemporalAdjuster result = TemporalAdjusters
				.ofDateAdjuster(localDate -> {
					localDate = localDate == null ? LocalDate.now() : localDate;
					localDate = localDate.plusDays(1);
					boolean condition = predicate == null ? false : predicate
							.test(localDate);
					while (!condition) {
						localDate = localDate.plusDays(1);
						condition = predicate == null ? true : predicate
								.test(localDate);
					}
					return localDate;
				});
		return result;
	}
}
