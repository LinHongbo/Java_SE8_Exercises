package com.linhongbo;

import java.io.File;
import java.util.Arrays;
import java.util.Optional;
import java.util.regex.Pattern;

public class Exercises3 {

	public static void main(String[] args) {
		File[] list = getFile("E://", "txt");

		Optional.ofNullable(list).map(files -> Arrays.asList(files).stream())
				.ifPresent(stream -> stream.forEach(System.out::println));
	}

	private static File[] getFile(String srcPath, final String stuffix) {

		return Optional
				.ofNullable(srcPath)
				.filter(path -> path != null)
				.map(File::new)
				.filter(file -> file.exists())
				.filter(file -> file.isDirectory())
				.map(file -> {
					return file.listFiles((file1, name) -> {
						Pattern p = Pattern.compile(new StringBuilder(".")
								.append(Optional.ofNullable(stuffix)
										.orElse("*")).append("$").toString());
						return p.matcher(name).find();
					});
				}).orElse(null);
	}

}
