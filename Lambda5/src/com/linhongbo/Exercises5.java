package com.linhongbo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Exercises5 {
	public static void main(String[] args) {
		print(7, 7, 1992);
	}

	private static void print(int day, int month, int year) {
		LocalDate birthday = LocalDate.of(year, month, day);
		LocalDate today = LocalDate.now();
		System.out.printf("您已经存活了：%d 天.\n", birthday
				.until(today, ChronoUnit.DAYS));
		
		LocalDate date = birthday.plusDays(10000);
		System.out.println("万日寿：" + date.format(DateTimeFormatter.ISO_DATE));
	}
}
