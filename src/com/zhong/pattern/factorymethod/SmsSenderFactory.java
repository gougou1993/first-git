package com.zhong.pattern.factorymethod;

public class SmsSenderFactory extends AbstractFactory {
	
	@Override
	public Sender produce() {
		return new SmsSender();
	}
}
