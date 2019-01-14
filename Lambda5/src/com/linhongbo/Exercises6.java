package com.linhongbo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Exercises6 {
	public static void main(String[] args) {
		printf(5);
	}
	
	private static void printf(int targetDay) {
		LocalDate indexDate = LocalDate.of(2000, 1, 1);
		indexDate = indexDate.plusDays((targetDay - indexDate.getDayOfWeek().getValue() + 7) % 7);
		int count = 0;
		while (indexDate.getYear() < 2100) {
			if(count++ % 12 == 0){
				System.out.println();
			}
			System.out.printf("%s\t", indexDate.format(DateTimeFormatter.ISO_DATE));
			indexDate = indexDate.plusDays(7);
		}
	}
}
