package com.zhong.proxy;
/**
 * 没有实现接口
 * @author admin
 *
 */
public class UserDAO {

	public void add(Object o){
		System.out.println("add:"+o.toString());
	}
	public void get(Object o){
		System.out.println("get:"+o.toString());
	}
	
	public final void finalMethod(Object o){
		System.out.println("finalMethod can not proxy");
	}
	
	private void privateMethod(Object o){
		System.out.println("privateMethod can not proxy");
	}
}
