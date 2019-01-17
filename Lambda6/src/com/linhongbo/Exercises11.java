package com.linhongbo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Exercises11 {
	public static void main(String[] args) {

		repeat(() -> {
			System.out.println("请输入密码:");
			String result = null;
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			try {
				result = bufferedReader.readLine();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
		}, item -> {
			return "secret".equals(item);
		});
		
	}

	private static <T> CompletableFuture<T> repeat(Supplier<T> action, Predicate<T> until) {

		CompletableFuture<T> result = CompletableFuture.supplyAsync(action);
		result.thenAcceptAsync(t -> {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (until.test(t)) {
				System.out.println("密码正确");
			} else {
				System.out.println("密码错误，请重试。");
				repeat(action, until);
			}
		});
		ForkJoinPool.commonPool().awaitQuiescence(4, TimeUnit.SECONDS);
		return result;
	}
}
