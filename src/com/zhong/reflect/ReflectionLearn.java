package com.zhong.reflect;

import java.lang.reflect.Method;

public class ReflectionLearn {

	
	public ReflectionLearn() {
	}
	
	public void instanceMethod(){
		System.out.println("instanceMethod");
	}
	
	public static void staticMethod(){
		System.out.println("staticMethod");
	}
	public static void main(String[] args) {
		
		//包括继承的方法
		Method[] allMethods = ReflectionLearn.class.getMethods();
		
		//本类声明的方法
		Method[] declareMethods = ReflectionLearn.class.getDeclaredMethods();
		
		for (Method method : allMethods) {
			System.out.println(method.getName());
		}
		System.out.println("-------------");
		for (Method method : declareMethods) {
			System.out.println(method.getName());
		}
		
	}
}
