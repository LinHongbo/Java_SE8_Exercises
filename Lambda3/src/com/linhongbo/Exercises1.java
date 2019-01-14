package com.linhongbo;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Exercises1 {
	public static void main(String[] args) {
		for (int i = 0; i < 11; i++) {
			logIf(Level.INFO, i, (item) -> item == 10, "ssssssssss", (item) -> {
				Logger logger = Logger.getGlobal();
				logger.info(item);
			});
		}
	}

	private static void logIf(Level level, int i, Predicate<Integer> condition, String result, Consumer<String> consumer) {
		Logger logger = Logger.getGlobal();
		if (condition.test(i) && logger.isLoggable(level)) {
			consumer.accept(result);
		}
	}
}
