package com.linhongbo;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exercises2 {

	public static void main(String[] args) {
		File[] list = getDirectory("E://");
		List<String> result = null;
		// 第 1 种
		// 普通模式
		if (list != null) {
			for (File file : list) {
				try {
					System.out.println(file.getCanonicalPath());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		// 第 2 种
		// stream 用来做数据的中间转化处理比较合适，
		if (list != null) {
			result = Arrays.asList(list).stream().map(file -> {
				try {
					return file.getCanonicalPath();
				} catch (Exception e) {
					e.printStackTrace();
				}
				return "";
			}).collect(Collectors.toList());
			System.out.println(result);
		}

		// 第 3 种
		// option 主要是为了处理判空的情况，对于list类等1对多的数据结构，需要先转成stream
		list = getDirectory("E://");
		result = Optional.ofNullable(list).map(files -> {
			return Arrays.asList(files).stream();
		}).orElse(Stream.empty()).map(file -> {
			try {
				return file.getCanonicalPath();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "";
		}).collect(Collectors.toList());
		System.out.println(result);
	}

	private static File[] getDirectory(String path) {
		File[] result = null;
		File src = new File(path);
		if (src.isDirectory()) {
			result = src.listFiles(Exercises2::listFiles);
		}
		return result;
	}

	private static boolean listFiles(File file) {
		if (file.isDirectory()) {
			return true;
		} else {
			return false;
		}
	}

}
