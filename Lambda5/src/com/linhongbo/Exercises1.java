package com.linhongbo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Exercises1 {
	public static void main(String[] args) {
		LocalDate localDate = LocalDate.now();
		localDate = localDate.withDayOfYear(1);
		localDate = localDate.plus(255, ChronoUnit.DAYS);
		System.out.println("localDate = " + localDate);
	}
}
