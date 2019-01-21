package com.linhongbo;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BinaryOperator;

public class Exercises1 {

	public static void main(String[] args) {
		String[] list = new String[] { "djkfs", "weriew", "vcnxbm", "sdnwqer", "odrteworoe", "dfowe[er[w", "pqwrj3221rmgbg,", "owieroiewtw", "ropweiotyer", "oidshfdslfd" };
		AtomicReference<String> atomicReference = new AtomicReference<String>();
		BinaryOperator<String> operator = (first, second) -> {
			try {
				return first.length() > second.length() ? first : second;
			} catch (Exception e) {
				return first != null ? first : second;
			}
		};

		ExecutorService pools = Executors.newCachedThreadPool();
		Arrays.stream(list).forEach(item -> {
			pools.submit(() -> {
				atomicReference.accumulateAndGet(item, operator);
			});
		});
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("the longest world is " + atomicReference.get());
	}
}
