package com.linhongbo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAccumulator;

public class Exercises4 {

	public static void main(String[] args) throws InterruptedException {

		long[] list = new long[] { 1, 32453465, 65756, 3432, 65875, 2343245, 56765, 24354, 43654, 76, 8978, 43288888888883l, 9876666666666l };
		LongAccumulator longAccumulator = new LongAccumulator(Math::max, 0);
		ExecutorService executorService = Executors.newCachedThreadPool();
		for (int j = 0; j < list.length; j++) {
			executorService.submit(() -> {
				for (int i = 0; i < list.length; i++) {
					longAccumulator.accumulate(list[i]);
				}
			});
		}
		
		Thread.sleep(100);
		System.out.println(longAccumulator.get());
	}
}
