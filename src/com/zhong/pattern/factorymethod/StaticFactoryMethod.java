package com.zhong.pattern.factorymethod;
/**
 * 静态工厂方法模式，将上面的多个工厂方法模式里的方法置为静态的，不需要创建实例，直接调用即可。
 * @author admin
 *
 */
public class StaticFactoryMethod {
	
	public static Sender produceEmailSender(){
		return new EmailSender();
	}
	public static Sender produceSmsSender(){
		return new SmsSender();
	}

}
