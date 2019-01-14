package com.linhongbo;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Exercises12 {
	public static void main(String[] args) {

		String content = "";
		try {
			content = new String(Files.readAllBytes(Paths
					.get("C:\\Users\\Administrator\\Desktop\\user_main.c")), StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Stream<String> words1 = Stream.of(content.split("[\\P{L}]+"));
		long count = System.nanoTime();
		System.out.println(sum1(words1));
		System.out.println(System.nanoTime() - count);
	}

	private static int sum1(Stream<String> source) {
		AtomicInteger result = new AtomicInteger();

		source.parallel().filter(item -> {
			if (item.length() < 12) {
				result.getAndIncrement();
				return true;
			} else {
				return false;
			}
		}).forEach(item -> System.out.printf("%s\t", item));
		return result.get();
	}
}
