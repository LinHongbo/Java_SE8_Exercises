package com.linhongbo;

import java.util.ArrayList;
import java.util.List;

public class Exercises8 {
	public static void main(String[] args) {
		String[] names = {"Peter", "Paul", "Mary"};
		List<Runnable> runners = new ArrayList<Runnable>();
		for(String name : names){
			runners.add(() -> System.out.println(name));
		}
		
		for (int i = 0; i < names.length; i++) {
			String name = names[i];
			runners.add(() -> System.out.println(name));
		}
		
		for (int i = 0; i < runners.size(); i++) {
			new Thread(runners.get(i)).start();
		}
	}
}
