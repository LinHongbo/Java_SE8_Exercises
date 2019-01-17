package com.linhongbo;

import java.util.Arrays;

public class Exercises9 {
	public static void main(String[] args) {

		Matrix[] result = new Matrix[10];
		Arrays.parallelSetAll(result, i -> new Matrix());
		Matrix.parallelPrefix(result);
		// 注意
		// |f(n+1), f(n)|
		// |f(n), f(n-1)|
		System.out.println("1");
		Arrays.stream(result).forEach(item -> {
			System.out.println(item.result[0][0]);
		});

	}

	static class Matrix {

		long[][] result = new long[][] { { 1, 1 }, { 1, 0 } };

		static void parallelPrefix(Matrix[] data) {
			Arrays.parallelPrefix(data, (first, second) -> {
				second.result[0][0] = second.result[0][0] * first.result[0][0] + second.result[0][1] * first.result[1][0];
				second.result[0][1] = second.result[0][0] * first.result[1][0] + second.result[1][0] * first.result[1][1];
				second.result[1][0] = second.result[1][0] * first.result[0][0] + second.result[1][1] * first.result[1][0];
				second.result[1][1] = second.result[1][0] * first.result[0][1] + second.result[1][1] * first.result[1][1];
				return second;
			});
		}
	}
}
