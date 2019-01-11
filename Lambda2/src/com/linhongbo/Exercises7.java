package com.linhongbo;

import java.util.stream.Stream;

public class Exercises7 {
	public static void main(String[] args) {
		long count = Stream.iterate(0, i -> i++)/*.limit(1000000)*/.count();
		System.out.println(count);
	}
}
