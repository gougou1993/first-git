package com.zhong.pattern.proxy;
/**
 * 静态的代理的目标类
 * @author admin
 */
public class Actor implements Play {

	private String name;
	
	public Actor(String name) {
		this.name = name;
	}
	@Override
	public void sing(String songName) {
		System.out.println("演唱歌曲："+songName);
	}

	@Override
	public void dance(String danceName) {
		System.out.println("跳"+danceName+"");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
