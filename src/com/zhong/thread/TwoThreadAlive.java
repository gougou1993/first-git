package com.zhong.thread;

public class TwoThreadAlive extends Thread {

	@Override
	public void run() {
		// super.run();
		for (int i = 0; i < 10; i++) {
			printMsg();
		}
	}

	public void printMsg() {
		Thread currentThread = Thread.currentThread();
		String threadName = currentThread.getName();
		System.out.println("name=" + threadName);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwoThreadAlive tt = new TwoThreadAlive();
		tt.setName("Thread");
		System.out.println("before start(), tt.isAlive()=" + tt.isAlive());
		
		tt.start();
		System.out.println("just after start(), tt.isAlive()=" + tt.isAlive());
		
		for (int i = 0; i < 10; i++) {
			tt.printMsg();
		}
		System.out.println("The end of main(), tt.isAlive()=" + tt.isAlive());
	}

}
