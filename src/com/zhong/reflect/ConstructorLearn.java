package com.zhong.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ConstructorLearn {

	private static final String S_F_FILED = "1";
	
	private String private_filed = "p_FILED";
	
	public String public_filed = "p_filed";
	
	public ConstructorLearn() {
	}
	
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		Class aClass = ConstructorLearn.class;
		Constructor[] constructors = aClass.getConstructors();
		
		for (Constructor constructor : constructors) {
			
			Class[] parameterTypes = constructor.getParameterTypes();

			ConstructorLearn cl = (ConstructorLearn) constructor.newInstance();
		}
	}
	
}


