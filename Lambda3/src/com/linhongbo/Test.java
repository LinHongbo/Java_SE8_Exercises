package com.linhongbo;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		List<?>[] lsa = new List<?>[10]; // Not really allowed.
		Object[] oa = (Object[]) lsa;
		List<Integer> li = new ArrayList<Integer>();
		li.add(new Integer(3));
		oa[1] = li; // Unsound, but passes run time store check
		lsa[1].get(0); // Run-time error: ClassCastException.
	}

}
