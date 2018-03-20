package com.zhong.proxy;
/**
 * jdk动态代理
 *  1.
 * @author admin
 *
 */
public class ProxyTest {

	public static void main(String[] args) {
		
		LiuDeHuaProxy proxyFactory = new LiuDeHuaProxy(new LiuDeHua());
		
		Person proxy = proxyFactory.getProxy();
		
		proxy.sing("I Love you");
	}
}
