package com.zhong.pattern.bridge;

public class SourceSub1 implements Sourceable {

	@Override
	public void method() {
		System.out.println("Sourcesub1 method");
	}

}
