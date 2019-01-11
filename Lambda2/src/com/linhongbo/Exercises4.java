package com.linhongbo;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Exercises4 {

	public static void main(String[] args) {
		int[] values = { 1, 4, 9, 16 };
		IntStream is = Arrays.stream(values);
		is.forEachOrdered(System.out::println);
	}
}
