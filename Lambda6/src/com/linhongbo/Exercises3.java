package com.linhongbo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Exercises3 {
	
	private static AtomicLong atomicLong = new AtomicLong();
	private static LongAdder longAdder = new LongAdder();
	
	public static void main(String[] args) {
		BiConsumer<String, Runnable> biConsumer = (item, runnable) -> {
			long begin = System.currentTimeMillis();
			ExecutorService pool = Executors.newCachedThreadPool();
			for (int i = 0; i < 1000; i++) {
				pool.submit(() -> {
					for (int j = 0; j < 100000; j++) {
						runnable.run();
					}
				});
			}
			long end = System.currentTimeMillis();
			System.out.println("item = " + item + ": " + (end - begin));
		};
		
		testAtomicLong(biConsumer);
		testLongAddder(biConsumer);
	}
	
	private static void testAtomicLong(BiConsumer<String, Runnable> item) {
		item.accept("testAtomicLong", () -> atomicLong.incrementAndGet());
	}
	
	private static void testLongAddder(BiConsumer<String, Runnable> item) {
		item.accept("testLongAddder", () -> longAdder.add(1));
	}
}
