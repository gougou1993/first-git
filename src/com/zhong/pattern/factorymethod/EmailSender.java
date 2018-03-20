package com.zhong.pattern.factorymethod;
/**
 * 邮件发送实现
 * @author admin
 *
 */
public class EmailSender implements Sender {

	@Override
	public void send(String msg) {
		System.out.println("发送邮件"+msg);
	}

}
