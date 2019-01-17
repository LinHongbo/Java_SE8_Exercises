package com.linhongbo;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exercises5 {

	private static ExecutorService pool = Executors.newCachedThreadPool();
	private static ConcurrentHashMap<String, Set<File>> map = new ConcurrentHashMap<String, Set<File>>();

	public static void main(String[] args) throws InterruptedException {
		getDirectory(new File("E:\\Documents\\Downloads\\SampleVideoPlayer"));
		Thread.sleep(5000);
		map.forEach((first, second) -> {
			second.stream().forEach(item -> {
				System.out.println("key = " + first + ", value = " + item
						.getName());
			});
		});

		System.out.println(map.size());
	}

	private static void getDirectory(File parent) {
		Optional.of(parent).ifPresent(item -> {
			if (item.isDirectory()) {
				File[] childs = item.listFiles();
				Arrays.stream(childs).forEach(child -> getDirectory(child));
			} else if (item.isFile()) {
				getFile(item);
			}
		});
	}

	private static void getFile(File parent) {
		pool.submit(() -> {
			Optional.of(parent)
					.ifPresent(item -> {
						if (item.isDirectory()) {
							return;
						}
						try {
							String content = new String(Files
									.readAllBytes(Paths.get(item
											.getCanonicalPath())), StandardCharsets.UTF_8);
							String[] contents = content.split("[\\P{L}]+");
							Arrays.stream(contents)
									.forEach(s -> {
										map.merge(s, new HashSet<File>(), (first, second) -> {
											second.add(item);
											first.addAll(second);
											return first;
										});
									});
						} catch (Exception e) {
							e.printStackTrace();
						}
					});
		});
	}

}
