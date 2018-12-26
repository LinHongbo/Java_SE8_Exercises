package com.linhongbo;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Exercises9 {

	interface Collection2<T> extends Collection<T> {
		default void forEachIf(Consumer<T> action, Predicate<T> filter) {
			forEach(item -> {
				if (filter.test(item)) {
					action.accept(item);
				}
			});
		}
	}

}
