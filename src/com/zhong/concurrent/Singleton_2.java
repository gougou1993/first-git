package com.zhong.concurrent;

public class Singleton_2 {

	/*
	 * 为了避免JIT编译器对代码的指令重排序优化，可以使用volatile关键字，
     * 通过这个关键字还可以使该变量不会在多个线程中存在副本，
     * 变量可以看作是直接从主内存中读取，相当于实现了一个轻量级的锁。
	 */
	private volatile static Singleton_2 instance = null;
	
	private Singleton_2(){
		
	}
	
	public static Singleton_2 getInstance(){
		
		if(instance == null){
			synchronized (Singleton_2.class){
				if(instance == null){
					instance = new Singleton_2();
				}
			}
		}
		return instance;
	}
	/*变量在有了volatile修饰之后，
	 * 对变量的修改会有一个内存屏障的保护，
	 * 使得后面的指令不能被重排序到内存屏障之前的位置。
	 * volalite变量的读性能与普通变量类似，
	 * 但是写性能要低一些，因为它需要插入内存屏障指令来保证处理器不会发生乱序执行。
	 * 即便如此，大多数场景下volatile的总开销仍然要比锁低，所以volatile的语义能满足需求时候，选择volatile要优于使用锁
	 * 
	 */
}
