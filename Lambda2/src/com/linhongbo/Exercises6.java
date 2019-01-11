package com.linhongbo;

import java.util.stream.Stream;

public class Exercises6 {
	public static void main(String[] args) {
		String s = "dsfsgfdngjkfdlfkweoirirknr";
		Stream.iterate(0, i -> i + 1).limit(s.length()).map(i -> s.charAt(i))
				.forEach(System.out::println);
	}
}
