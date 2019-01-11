package com.linhongbo;

import java.util.stream.Stream;

public class Exercises5 {
	public static void main(String[] args) {
		random(0L, 25214903917L, 11,  (long)Math.pow(2, 48));
	}

	private static void random(long seed, long a, long c, long m) {
		Stream.iterate(seed, item -> (a * item + c) % m).limit(10).forEach(System.out::println);
	}
}
