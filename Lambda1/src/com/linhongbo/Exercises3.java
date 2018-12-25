package com.linhongbo;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Optional;
import java.util.regex.Pattern;

public class Exercises3 {

	public static void main(String[] args) {
		File[] list = getFile("E://", "txt");

		Optional.ofNullable(list).map(files -> Arrays.asList(files).stream())
				.ifPresent(stream -> stream.forEach(System.out::println));
	}

	private static File[] getFile(String srcPath, String stuffix) {

		return Optional.ofNullable(srcPath).filter(path -> path != null)
				.map(File::new).filter(file -> file.exists())
				.filter(file -> file.isDirectory())
				.map(file -> file.listFiles(getFilter(file, stuffix)))
				.orElse(null);
	}

	private static FilenameFilter getFilter(File file, String stuffix) {
		return (file1, name) -> {
			Pattern p = Pattern.compile(new StringBuilder(".")
					.append(Optional.ofNullable(stuffix).orElse("*"))
					.append("$").toString());
			return p.matcher(name).find();
		};
	}

}
