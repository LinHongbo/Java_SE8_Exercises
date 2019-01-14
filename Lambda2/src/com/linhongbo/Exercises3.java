package com.linhongbo;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Exercises3 {

	public static void main(String[] args) throws IOException {

		String content1 = new String(Files.readAllBytes(Paths
				.get("C:\\Users\\Administrator\\Desktop\\user_main.c")), StandardCharsets.UTF_8);
		List<String> words = Arrays.asList(content1.split("[\\P{L}]+"));


		// 代码块 B
		long parallelStart = System.nanoTime();
		int parallelCount = words.parallelStream().filter(word -> word.length() > 12).map(String::length).reduce(0, (a, b) -> a + b, (a, b) -> a + b);
		long parallelEnd = System.nanoTime();
		System.out
				.println("nanos = " + (parallelEnd - parallelStart) + ", parallelStream = " + parallelCount);
		
		// 代码块 A
		long singleStart = System.nanoTime();
		int singleCount = words.stream().filter(word -> word.length() > 12).map(String::length).reduce(0, (a, b) -> a + b, (a, b) -> a + b);
		long singleEnd = System.nanoTime();
		System.out.println("nanos = " + (singleEnd - singleStart) + ", stream = " + singleCount);
		
		

		

	}

}
