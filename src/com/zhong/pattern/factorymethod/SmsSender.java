package com.zhong.pattern.factorymethod;
/**
 * 短信发送
 * @author admin
 *
 */
public class SmsSender implements Sender {

	@Override
	public void send(String msg) {
		System.out.println("发送短信"+msg);
	}

}
