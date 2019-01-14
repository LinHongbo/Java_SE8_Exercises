package com.linhongbo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Exercises7 {
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>(){
			{
				add("ab cd n");
				add("a bcde n");
				add("abcds n");
				add("abCda n");
				add("abcDmn n");
				add("aBcdioyu n");
			}
		};
		
		Comparator<String> comparator = getComparator(false, true, true);
		Collections.sort(list, comparator);
		list.stream().forEach(System.out::println);
		
	}
	

	private static <T extends String> Comparator<T> getComparator(boolean isAsc, boolean isIgnoreCase, boolean isIgnoreSpace) {
		return (T first, T second) -> {
			String targetFirst = first;
			String targetSecond = second;
			if(isIgnoreSpace){
				targetFirst = targetFirst.replace(" ", "");
				targetSecond = targetSecond.replace(" ", "");
			}
			if(isIgnoreCase){
				targetFirst = targetFirst.toLowerCase();
				targetSecond = targetSecond.toLowerCase();
			}
			int result = 0;
			result = targetFirst.compareTo(targetSecond);
			if(!isAsc){
				result = 0 - result;
			}
			return result;
			
		};
	}
}
