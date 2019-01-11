package com.linhongbo;

import java.awt.List;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Stream;

public class Exercises12 {
	
	public static void main(String[] args) {
		Object[] powers = Stream.iterate(1.0,  p -> p * 2).peek(e -> System.out.println("Fetching " + e)).limit(20).toArray();
		Stream.empty().toArray(String[]::new);
	}
	
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
