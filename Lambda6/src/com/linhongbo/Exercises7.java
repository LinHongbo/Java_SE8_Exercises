package com.linhongbo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Exercises7 {
	public static void main(String[] args) {
		ConcurrentHashMap<String, Long> map = new ConcurrentHashMap<String, Long>();
		map.put("dsfhk", 3245l);
		map.put("dsfhfdgklk", 567l);
		map.put("dsfhdfgfdk", 123l);
		map.put("dsfjhkhlwerhk", 7654l);
		map.put("dswerwefhk", 2345l);
		map.put("dsfhkjhklk", 9976l);
		map.put("dsfcxzcxchk", 6786l);
		map.put("dwtiuertyusfhk", 234l);
		map.put("dsfhwerwerk", 067554l);
		map.put("dsdfgdfhk", 905433l);
		map.put("dsfzcxzvchk", 978032421111111113l);
		map.put("dsvczfhk", 5679343l);
		map.put("dsxvczzhk", 6587670l);
		map.put("dsasafhk", 890543l);
		map.put("dsfasdhk", 324765l);
		
		System.out.println(max(map));
	}
	
	private static Map.Entry<String, Long> max(ConcurrentHashMap<String, Long> map) {
		return map.reduceEntries(5, item -> {
			return item;
		}, (first, second) -> {
			return first.getValue() > second.getValue() ? first : second;
		});
	}
}
