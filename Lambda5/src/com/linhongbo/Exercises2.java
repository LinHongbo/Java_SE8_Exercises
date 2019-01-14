package com.linhongbo;

import java.time.LocalDate;

public class Exercises2 {

	public static void main(String[] args) {
		LocalDate localDate = LocalDate.of(2000, 2, 29);
		localDate = localDate.plusYears(1);
		System.out.println(localDate);
		System.out.println();
		
		localDate = LocalDate.of(2000, 2, 29);
		localDate = localDate.plusYears(4);
		System.out.println(localDate);
		System.out.println();
		
		localDate = LocalDate.of(2000, 2, 29);
		localDate = localDate.plusYears(1);
		localDate = localDate.plusYears(1);
		localDate = localDate.plusYears(1);
		localDate = localDate.plusYears(1);
		System.out.println(localDate);
		System.out.println();
	}

}
