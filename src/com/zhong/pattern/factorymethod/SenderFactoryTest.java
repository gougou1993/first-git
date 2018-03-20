package com.zhong.pattern.factorymethod;
/**
 * 
 * @author admin
 *
 */
public class SenderFactoryTest {

	public static void main(String[] args) {
		
		SenderFactory sf = new SenderFactory();
		
		Sender emailSender = sf.produce("email");
		emailSender.send("邮件");
		
		Sender smsSender = sf.produce("sms");
		smsSender.send("短信");
		
	}

}
