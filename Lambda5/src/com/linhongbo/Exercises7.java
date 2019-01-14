package com.linhongbo;

import java.time.LocalDateTime;

public class Exercises7 {

	public static void main(String[] args) {
		TimeInterval first = new TimeInterval(LocalDateTime.of(2019, 1, 14, 10, 00), LocalDateTime
				.of(2019, 1, 14, 11, 00));
		TimeInterval second = new TimeInterval(LocalDateTime.of(2019, 1, 14, 9, 00), LocalDateTime
				.of(2019, 1, 14, 10, 0));
		System.out.println(TimeInterval.checkConflct(first, second));
	}

	static class TimeInterval {

		private LocalDateTime begin;
		private LocalDateTime end;

		public TimeInterval(LocalDateTime begin, LocalDateTime end) {
			super();
			this.begin = begin;
			this.end = end;
		}

		private static boolean checkConflct(TimeInterval first, TimeInterval second) {
			if (first.begin.isBefore(second.begin)) {
				return first.end.isAfter(second.begin);
			} else if (first.begin.isEqual(second.begin)) {
				return true;
			} else {
				return second.end.isAfter(first.begin);
			}
		}
	}
}
