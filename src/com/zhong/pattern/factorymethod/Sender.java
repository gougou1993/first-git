package com.zhong.pattern.factorymethod;
/**
 * 发送接口
 * @author admin
 *
 */
public interface Sender {
	/**
	 * 发送消息方法
	 * @param msg
	 */
	void send(String msg);
}
