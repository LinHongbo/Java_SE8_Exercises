package com.linhongbo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentHashMap.KeySetView;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

public class Test {

	public static void main(String[] args) {
		AtomicLong atomicLong = new AtomicLong();
		LongAdder longAdder = new LongAdder();
		longAdder.increment();
		System.out.println(longAdder.sum());
		longAdder.add(10);
		System.out.println(longAdder.sum());

		ConcurrentHashMap<String, Long> map = new ConcurrentHashMap<String, Long>();
		System.out.println(map.size());
		KeySetView<String, Long> set = map.keySet(10000L);
		set.add("java");
		System.out.println(map.get("java"));

		CompletableFuture<String> future = new CompletableFuture<String>();
	}
}
