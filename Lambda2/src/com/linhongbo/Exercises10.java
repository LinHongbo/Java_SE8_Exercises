package com.linhongbo;

import java.util.DoubleSummaryStatistics;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exercises10 {
	public static void main(String[] args) {
		Stream<Double> s1 = Stream.of(0.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 89.0);
		System.out.println(average1(s1));
		Stream<Double> s2 = Stream.of(0.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 89.0);
		System.out.println(average2(s2));
	}

	private static Double average1(Stream<Double> source) {
		DoubleSummaryStatistics s = source.collect(Collectors
				.summarizingDouble(Double::doubleValue));
		return s.getAverage();
	}
	
	private static Double average2(Stream<Double> source) {
		return source.collect(Collectors.averagingDouble(Double::doubleValue));
	}
}
