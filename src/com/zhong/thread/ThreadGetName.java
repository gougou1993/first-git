package com.zhong.thread;

public class ThreadGetName extends Thread {

	@Override
	public void run() {
//		super.run();
		for (int i = 0; i < 10; i++) {
			printMsg();
		}
	}
	public void printMsg(){
		Thread thread = Thread.currentThread();
		String name = thread.getName();
		System.out.println("name="+name);
	}
	public static void main(String[] args) {
		ThreadGetName tgn = new ThreadGetName();
		// 设置线程名字
		tgn.setName("myThread");
		tgn.start();
		
		for (int i = 0; i < 10; i++) {
			tgn.printMsg();
		}
		
	}

}
