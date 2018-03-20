package com.zhong.concurrent;
/**
 *   当类被加载时，静态变量instance会被初始化，此时类的私有构造函数会被调用，单例类的唯一实例将被创建。如果使用饿汉式单例来实现负载均衡器LoadBalancer类的设计，则不会出现创建多个单例对象的情况，
 *   可确保单例对象的唯一性。
 * @author admin
 *
 */
public class EagerSingleton {

	private static final EagerSingleton instance = new EagerSingleton();

	private EagerSingleton() {
	}

	public static EagerSingleton getInstance() {
		return instance;
	}
	
	public static void main(String[] args) {
		EagerSingleton e = EagerSingleton.getInstance();
		EagerSingleton e2 = EagerSingleton.getInstance();
		
		System.out.println(e == e2);
		
		
	}
}
