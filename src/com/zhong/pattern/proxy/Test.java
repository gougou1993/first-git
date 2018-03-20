package com.zhong.pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Test {

	public static void main(String[] args) {

		// 1.静态代理
		// 我们要代理的真实对象
		Actor actor = new Actor("刘德华");// 歌星--被代理对象
		Assistant assistant = new Assistant(actor);// 助手
		assistant.sing("笨小孩");
		assistant.dance("小苹果");

		// 2.jdk动态代理
		// 我们要代理哪个真实对象，就将该对象传进去，最后是通过该真实对象来调用其方法的
		InvocationHandler handler = new DynamicActorProxy(actor);
		
		Play play = (Play) Proxy.newProxyInstance(handler.getClass().getClassLoader(), actor.getClass().getInterfaces(),
				handler);
		play.sing("笨小孩");
	}

}
