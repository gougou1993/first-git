package com.zhong.pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
/**
 * jdk演员动态代理类
 * @author admin
 *
 */
public class DynamicActorProxy implements InvocationHandler{

	private Object target;// 被代理的对象
	
	public DynamicActorProxy(Object target) {
		this.target = target;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = method.invoke(this.target, args);
		return result;
		
	}

}
