package com.linhongbo;

import java.time.LocalDate;
import java.util.stream.IntStream;

public class Exercises4 {
	public static void main(String[] args) {
		print(3, 2019);
	}

	private static void print(int month, int year) {
		LocalDate localDate = LocalDate.of(year, month, 1);
		int index = localDate.getDayOfWeek().getValue();
		IntStream.iterate(1, i -> i++).limit(index)
				.forEach(i -> System.out.print("\t"));
		int count = localDate.plusMonths(1).minusDays(1).getDayOfMonth();
		IntStream.iterate(1, i -> ++i).limit(count).forEach(i -> {
			if((i + index - 1) % 7 == 0){
				System.out.printf("\n%d\t", i);
			} else {
				System.out.printf("%d\t", i);
			}
		});
	}
}
