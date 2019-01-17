package com.linhongbo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.BinaryOperator;

public class Exercises1 {

	public static void main(String[] args) {

		String[] list = new String[] { "djkfs", "weriew", "vcnxbm", "sdnwqer", "odrteworoe", "dfowe[er[w", "pqwrjrmgbg,", "owieroiewtw", "ropweiotyer", "oidshfdslfd" };
		AtomicReference<String> atomicReference = new AtomicReference<String>();
		BinaryOperator<String> operator = (first, second) -> {
			try {
				return first.length() > second.length() ? first : second;
			} catch (Exception e) {
				if (first != null) {
					return first;
				} else {
					return second;
				}
			}
		};

		ExecutorService pools = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			int index = i;
			pools.submit(() -> {
				Exercises1.updateAndGet(list[index], atomicReference, operator);
			});
		}

	}

	private static <T> void updateAndGet(T str, AtomicReference<T> reference, BinaryOperator<T> operator) {
		T result = reference.accumulateAndGet(str, operator);
		System.out.println(result);
	}

}
