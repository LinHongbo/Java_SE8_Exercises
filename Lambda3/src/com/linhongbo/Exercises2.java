package com.linhongbo;

import java.util.concurrent.locks.Lock;

public class Exercises2 {

	private static void withLock(Lock lock, Runnable runnable) {
		lock.lock();
		try {
			runnable.run();
		} catch (Exception e) {
			e.printStackTrace();
			lock.unlock();
		}
	}
}
