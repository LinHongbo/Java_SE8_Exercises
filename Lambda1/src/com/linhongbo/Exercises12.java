package com.linhongbo;

import java.util.Collection;
import java.util.stream.Stream;

public class Exercises12 {
	static abstract class Child<E> implements Collection<E>, Super<E>{
		 @Override
		 public Stream<E> stream() {
			return Collection.super.stream();
		 }
	}
		
	static interface Super<E> {
		Stream<E> stream();
	}
}
