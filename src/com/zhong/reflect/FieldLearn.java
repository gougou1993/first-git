package com.zhong.reflect;

import java.lang.reflect.Field;

public class FieldLearn {

	private String str = "1str";
	private int age = 11;
	protected String protectedField;

	public static String static_field = "static_field";

	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException {
		Class aClass = FieldLearn.class;

		// Field[] fields = aClass.getFields();
		Field[] fields = aClass.getDeclaredFields();

		for (Field field : fields) {
			System.out.print(field.getName() + " " + field.getType() + "\n");
		}
		FieldLearn objectInstance = (FieldLearn) aClass.newInstance();

		Object instanceValue = fields[0].get(objectInstance);
		System.out.println(instanceValue);

		// 设置变量的值
		fields[0].set(objectInstance, "objectInstance field value");

		System.out.println(fields[0].get(objectInstance));
		
		Field staticFiled = aClass.getField("static_field");

		System.out.println(staticFiled.get(null));

		// 设置类变量的值
		staticFiled.set(null, "set new static_field value");

		System.out.println(staticFiled.get(null));

	}
}
