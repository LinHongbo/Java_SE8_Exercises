package com.linhongbo;

import java.util.stream.Stream;

public class Exercises3 {
	private static void assertLib(boolean condition, Runnable safe, Runnable error)
			throws AssertionError {
		if (condition) {
			safe.run();
		} else {
			error.run();
			throw new AssertionError();
		}
	}

	private static void assertLib(boolean condition, Runnable safe)
			throws AssertionError {
		assertLib(condition, safe, null);
	}

	private static void assertLib(Runnable safe) throws AssertionError {
		assertLib(true, safe);
	}
}
