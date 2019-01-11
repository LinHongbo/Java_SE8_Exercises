package com.linhongbo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exercises9 {
	public static void main(String[] args) {
		List<String> list1 = new ArrayList<String>() {
			{
				add("1");
				add("2");
				add("3");
				add("4");
				add("5");
			}
		};

		List<String> list2 = new ArrayList<String>() {
			{
				add("11");
				add("22");
				add("33");
				add("44");
				add("55");
			}
		};

		List<String> list3 = new ArrayList<String>() {
			{
				add("111");
				add("222");
				add("333");
				add("444");
				add("555");
			}
		};
		// method1(Stream.of(list1, list2, list3)).stream().forEach(i ->
		// System.out.printf("%s\t", i));
		// method2(Stream.of(list1, list2, list3)).stream().forEach(i ->
		// System.out.printf("%s\t", i));
		method3(Stream.of(list1, list2, list3)).stream()
				.forEach(i -> System.out.printf("%s\t", i));

	}

	public static <T> List<T> method1(Stream<List<T>> source) {
		return source.flatMap(item -> item.stream())
				.collect(Collectors.toList());
	}

	public static <T> List<T> method2(Stream<List<T>> source) {
		return source.map(item -> item.stream())
				.reduce((a, b) -> Stream.concat(a, b)).get()
				.collect(Collectors.toList());
	}

	public static <T> List<T> method3(Stream<List<T>> source) {
		List<T> result = new ArrayList<T>();
		source.forEach(item -> {
			result.addAll(item);
		});
		return result;
	}
}
