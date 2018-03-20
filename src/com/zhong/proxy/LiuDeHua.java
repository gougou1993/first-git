package com.zhong.proxy;

/**
 * 代理的目标对象，实现Person接口
 * @author admin
 *
 */
public class LiuDeHua implements Person {

	@Override
	public String sing(String name) {
		System.out.println(name+"唱完了");
		return name+"唱完了";
	}

	@Override
	public String dance(String name) {
		System.out.println(name+"跳完了");
		return name+"跳完了";
	}

}
