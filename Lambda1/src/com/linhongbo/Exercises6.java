package com.linhongbo;

import java.util.concurrent.Callable;

public class Exercises6 {
	public static void main(String[] args) {
		new Thread(uncheck(() -> {
			System.out.println("zzzz");
			Thread.sleep(1000);
		})).start();
	
		new Thread(uncheck1(() -> {
			System.out.println("yyyyyyyyy");
			Thread.sleep(1000);
			return null;	// 这个可能就是区别吧？
		})).start();
	}

	private static Runnable uncheck(final RunnableEx runner) {
		return () -> {
			try {
				runner.run();
			} catch (Exception e) {
				e.printStackTrace();
			}
		};
	}
	
	private static Runnable uncheck1(final Callable<Void> caller) {
		return () -> {
				try {
					caller.call();
				} catch (Exception e) {
					e.printStackTrace();
				}
		};
	}

	private static interface RunnableEx {
		void run() throws Exception;
	}
}
