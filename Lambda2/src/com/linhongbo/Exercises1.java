package com.linhongbo;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Exercises1 {

	public static void main(String[] args) {
		try {
			String content = new String(Files.readAllBytes(Paths.get("C:\\Users\\Administrator\\Desktop\\user_main.c")), StandardCharsets.UTF_8);
			List<String> words = Arrays.asList(content.split("[\\P{L}]+"));
//			int count = 0;
//			for(String w : words){
//				if(w.length() > 12){
//					System.out.println(w);
//					count++;
//				}
//			}
//			System.out.println(count);
			
			// 估计题目不是想让我们使用流式编程
			long count = words.parallelStream().filter(word -> {return word.length() > 12 ? true : false;}).count();
			System.out.println(count);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
