package com.linhongbo;

public class Exercises7 {
	public static void main(String[] args) {
		Runnable task = andThen(() -> {
			System.out.println("hello");
		}, () -> {
			System.out.println("world");
		});
		new Thread(task).start();
	}

	private static Runnable andThen(Runnable task1, Runnable task2) {
		return () -> {
			task1.run();
			task2.run();
		};
	}
}
