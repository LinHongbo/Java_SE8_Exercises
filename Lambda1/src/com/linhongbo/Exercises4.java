package com.linhongbo;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exercises4 {
	public static void main(String[] args) {
		File[] files = new File("E://").listFiles();
		Stream<File> stream = Optional.ofNullable(files)
				.map(file -> Arrays.asList(file)).map(list -> list.stream())
				.orElse(Stream.empty());
		List<File> list = stream.sorted(Exercises4::sortDirectory)
				.collect(Collectors.toList());
		list.forEach(System.out::println);
   
	}

	private static <T extends File> int sortDirectory(T first, T second) {
		if (first == null && second == null || first != null && !first.exists() && second == null || first == null && second != null && !second
				.exists() || !first.exists() && !second.exists()) {
			return 0;
		} else if ((first == null || !first.exists()) && second != null & second
				.exists()) {
			return -1;
		} else if ((second == null || !second.exists()) && first != null && first
				.exists()) {
			return 1;
		} else {
			String firstName = first.getName();
			String secondName = second.getName();
			if (first.isDirectory()) {
				if (second.isDirectory()) {
					return firstName.compareToIgnoreCase(secondName);
				} else {
					return -1;
				}
			} else {
				if (second.isDirectory()) {
					return 1;
				} else {
					String firstNamePrefix = firstName.split("\\.")[0];
					String firstNameStuffix = firstName.split("\\.")[1];
					String secondNamePrefix = secondName.split("\\.")[0];
					String secondNameStuffix = secondName.split("\\.")[1];
					if (firstNamePrefix.equals(secondNamePrefix)) {
						return firstNameStuffix
								.compareToIgnoreCase(secondNameStuffix);
					}
					return firstNamePrefix
							.compareToIgnoreCase(secondNamePrefix);
				}
			}
		}

	}
}
