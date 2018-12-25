package com.linhongbo;

import java.io.File;
import java.util.Arrays;
import java.util.Optional;
import java.util.regex.Pattern;

public class Exercises3 {

	public static void main(String[] args) {
		File[] files = getFile("E://", "txt");

		Optional.ofNullable(files).map(list -> Arrays.asList(list).stream())
				.ifPresent(stream -> stream.forEach(System.out::println));
	}

	private static File[] getFile(String path, final String stuffix) {

		return Optional
				.ofNullable(path)
				.filter(path1 -> path != null)
				.map(File::new)
				.filter(file -> file.exists())
				.filter(file -> file.isDirectory())
				.map(file1 -> {
					return file1.listFiles((file, name) -> {
						Pattern p = Pattern.compile(new StringBuilder(".")
								.append(Optional.ofNullable(stuffix)
										.orElse("*")).append("$").toString());
						return p.matcher(name).find();
					});
				}).orElse(null);
	}

}
