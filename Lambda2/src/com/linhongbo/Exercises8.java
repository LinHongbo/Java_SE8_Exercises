package com.linhongbo;

import java.util.Iterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Exercises8 {
	public static void main(String[] args) {
		Stream<Integer> stream1 = zip(Stream.of(1, 3, 5), Stream.of(2, 4, 6, 8, 10));
        stream1.forEach(x -> System.out.print(String.format("%d ", x)));
        System.out.println();

        Stream<Integer> stream2 = zip(Stream.iterate(1, x -> x * 2), Stream.of(2, 4, 6, 8, 10));
        stream2.forEach(x -> System.out.print(String.format("%d ", x)));
        System.out.println();


        Stream<Integer> stream3 = zip(Stream.iterate(1, x -> x * 2), Stream.iterate(1, x -> x * 3)).limit(10);
        stream3.forEach(x -> System.out.print(String.format("%d ", x)));
        System.out.println();
	}

	public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
		Iterator<T> iterator1 = first.iterator();
		Iterator<T> iterator2 = second.iterator();
		Iterator<T> iterator = new Iterator<T>() {

			boolean isFirst = false;

			@Override
			public boolean hasNext() {
				isFirst = !isFirst;
				return isFirst ? iterator1.hasNext() : iterator2.hasNext();
			}

			@Override
			public T next() {
				return isFirst ? iterator1.next() : iterator2.next();
			}

		};
		
		Iterable<T> iterable = () -> iterator;
		boolean parallel = first.isParallel() || second.isParallel();
		return StreamSupport.stream(iterable.spliterator(), parallel);
	}
}
