package com.zhong.reflect;

import java.lang.reflect.Method;
import java.util.Arrays;

public class MethodLearn {
	
	private String privateMethod(String arg1,String arg2){
		System.out.println("arg1");
		return arg1 + arg2;
	}
	public MethodLearn(){
		System.out.println("MethodLearn");
	}
	
	public static void main(String[] args) {
		
		Method[] methods = MethodLearn.class.getDeclaredMethods();
		for (Method method : methods) {
			System.out.println(method.getName());
			System.out.println(method.getReturnType());
			System.out.println(Arrays.toString(method.getParameterTypes()));
		}
	}
}
