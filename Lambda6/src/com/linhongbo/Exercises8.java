package com.linhongbo;

import java.util.Arrays;

public class Exercises8 {
	public static void main(String[] args) {
		int[] a = new int[100000000];
		for (int i = 0; i < a.length; i++) {
			a[i] = 100000000 - i;
		}
		long begin = System.currentTimeMillis();
		Arrays.sort(a);
//		Arrays.parallelSort(a);
		long end = System.currentTimeMillis();
		
		System.out.println("time = " + (end - begin));
	}
}
