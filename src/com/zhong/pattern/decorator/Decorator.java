package com.zhong.pattern.decorator;
/**
 * 装饰类
 * @author admin
 *
 */
public class Decorator implements Sourceable {

	// 持有被装饰类的引用
	private Sourceable source;
	
	public Decorator(Sourceable source) {
		super();
		this.source = source;
	}
	@Override
	public void method() {
		System.out.println("before decorator");
		source.method();
		System.out.println("after decorator");
	}

}
