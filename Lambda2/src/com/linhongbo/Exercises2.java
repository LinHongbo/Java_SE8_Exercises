package com.linhongbo;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Exercises2 {

	public static void main(String[] args) {
		try {
			String content = new String(Files.readAllBytes(Paths
					.get("C:\\Users\\Administrator\\Desktop\\user_main.c")), StandardCharsets.UTF_8);
			List<String> words = Arrays.asList(content.split("[\\P{L}]+"));

			// 注意不要使用并行模式 words.parallelStream()
			words.stream().filter(word -> {
				if(word.length() > 12){
					System.out.println("bingo");
					return true;
				} else {
					return false;
				}
			}).limit(3).peek(e -> System.out.println(e)).count();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
