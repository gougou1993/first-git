package com.zhong.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@MyAnnotation(name = "name", value = "value")
public class AnnotationLearn {

	@MyMethodAnnotation(name="")
	public void f(){
		System.out.println();
	}
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		Class aClass = AnnotationLearn.class;
		Annotation annotation = aClass.getAnnotation(MyAnnotation.class);
		if (annotation instanceof MyAnnotation) {
			MyAnnotation myAnnotation = (MyAnnotation) annotation;
			System.out.println("name: " + myAnnotation.name());
			System.out.println("value: " + myAnnotation.value());

		}
		
		Method method = aClass.getMethod("f", null);
		
		
		Annotation[] annotations = method.getAnnotations();
		for(Annotation annotation1 : annotations){
			
			    if(annotation1 instanceof MyMethodAnnotation){
		
			    	MyMethodAnnotation myAnnotation = (MyMethodAnnotation) annotation1;
			        System.out.println("name: " + myAnnotation.name());
			        System.out.println("value: " + myAnnotation.value());
			
			    }
		
			}

		
	}
}
