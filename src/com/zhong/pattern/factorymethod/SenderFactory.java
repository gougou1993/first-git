package com.zhong.pattern.factorymethod;

/**
 * 工厂类
 * @author admin
 *
 */
public class SenderFactory {
	/**
	 * 根据类型返回对象
	 * @param type
	 * @return
	 */
	public Sender produce(String type) {  
        if ("email".equals(type)) {  
            return new EmailSender();  
        } else if ("sms".equals(type)) {  
            return new SmsSender();  
        } else { 
            System.out.println("请输入正确的类型!");  
            return null;  
        }  
    }  
}
