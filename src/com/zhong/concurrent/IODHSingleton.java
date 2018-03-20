package com.zhong.concurrent;

/**
 * 
 * @author admin
 * 
 *         3.5 一种更好的单例实现方法
 *         饿汉式单例类不能实现延迟加载，不管将来用不用始终占据内存；懒汉式单例类线程安全控制烦琐，而且性能受影响。可见，无论是饿汉式单例还是懒汉式单例都存在这样那样的问题，有没有一种方法，能够将两种单例的缺点都克服，而将两者的优点合二为一呢？答案是：Yes！下面我们来学习这种更好的被称之为Initialization
 *         Demand Holder (IoDH)的技术。
 *         在IoDH中，我们在单例类中增加一个静态(static)内部类，在该内部类中创建单例对象，再将该单例对象通过getInstance()方法返回给外部使用，实现代码如下所示：
 *
 */
public class IODHSingleton {

	private IODHSingleton() {

	}

	private static class HolderClass {

		private final static IODHSingleton instance = new IODHSingleton();
		
	}

	public static IODHSingleton getInstance() {
		return HolderClass.instance;
	}
	
	public static void main(String[] args) {
		
		IODHSingleton s = IODHSingleton.getInstance();
		IODHSingleton s2 = IODHSingleton.getInstance();
		
		System.out.println(s == s2);
	}
}
