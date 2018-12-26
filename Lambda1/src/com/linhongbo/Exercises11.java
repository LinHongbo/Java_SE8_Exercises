package com.linhongbo;

public class Exercises11 {

	public static void main(String[] args) {
		T t = new T();
		t.f();
	}
	
	interface I {
//		void f();
		default void f(){
			System.out.println("IIIIIIIIIIIIIII");
		}
//		static void f(){
//			System.out.println("static IIIIIIIIIIIIIII");
//		}
	}
	
	interface J {
//		void f();
		default void f(){
			System.out.println("JJJJJJJJJJJJJJJJ");
		}
		
//		static void f(){
//			System.out.println("static JJJJJJJJJJJJJJJJ");
//		}
	}
	
	static class T extends S implements I, J{

//		@Override
//		public void f() {
//			System.out.println("TTTTTTTTTTTTTTT");
//			I.super.f();
//			J.super.f();
//		}
		
	}
	
	static abstract class S {
		public void f(){
			System.out.println("sssssssssssssss");
		}
	}
}
