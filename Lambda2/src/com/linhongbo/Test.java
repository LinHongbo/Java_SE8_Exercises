package com.linhongbo;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
//		Map<String, Set<Locale>> map = locales.collect(Collectors
//				.groupingBy(Locale::getCountry, Collectors.toSet()));
//		map.forEach((key, value) -> System.out.println("key = " + key + " value" + value));
		
//		Map<String, Set<String>> map = locales.collect(Collectors.groupingBy(Locale::getDisplayName, Collectors.mapping(Locale::getDisplayLanguage, Collectors.toSet())));
//		map.forEach((key, value) -> System.out.println("key = " + key + ", value = " + value));
		
//		String sentence = "\uD835\uDD46 is the set of octonions";
//		IntStream codes = sentence.codePoints();
//		codes.forEach(value -> System.out.printf("%x\n", value));
//		System.out.println();
//		codes = sentence.chars();
//		codes.forEach(value -> System.out.printf("%x\n", value));
	
		String[] intArray = new String[1000000];
		for(int i = 0; i < 1000000; i++){
			intArray[i] = "" + i;
		}
//		
		Stream<String> stream = Arrays.stream(intArray);
//		long s = System.currentTimeMillis();
//		Map<Integer, List<String>> map = stream.parallel().collect(Collectors.groupingBy/*Concurrent*/(String::length));
//		System.out.println(System.currentTimeMillis() - a);
//		map.forEach((key, value) -> System.out.println("key = " + key + " value" + value));
	
//		stream.map(value -> {return Math.pow(Double.valueOf(value), 2);}).reduce(0.0, (a, b) -> a +b, (c , d) -> c +d);
		
//		System.out.println(System.currentTimeMillis() - s);
		compareForAndStream();
		
//		List<String> wordList = new ArrayList<String>();
//		Stream<String> words = wordList.stream();
//		wordList.add("END");
//		wordList.add("hello");
//		wordList.add("world");
//		long n = words.distinct().count();
//		System.out.println(n);
//		words.forEach(s -> {if (s.length() < 12) wordList.remove(s);});
//		words.forEach(s -> {if (s.length() < 12) System.out.println(s);});
		System.out.println(Runtime.getRuntime().availableProcessors());
	}
	
	public static void compareForAndStream() {
        //p1表示for性能,p2表示流处理性能
        long p1 = 0, p2 = 0;
        int n = 500000;
        ArrayList<Integer> arr = new ArrayList<Integer>(100);
        for(int j = 0; j < 100; j ++) {
            for(int i = 0; i < n; i ++) {
                arr.add(i);
            }
//            Integer sum = 0;
//            long t1 = System.nanoTime();
//            for(Integer v : arr) {
//                sum = sum + v;
//            }
            long t2 = System.nanoTime();
            arr.stream().reduce(0, (a, b) -> a + b);
//            arr.parallelStream().reduce(0, (a, b) -> a + b, (a, b) -> a + b);
            long t3 = System.nanoTime();
//            p1 += (t2 - t1);
            p2 += (t3 - t2);
            arr.clear();
        }
//        System.out.println(p1 / 100 / 1000);
        System.out.println(p2 / 100 / 1000);

    }

}
