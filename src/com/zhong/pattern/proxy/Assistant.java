package com.zhong.pattern.proxy;
/**
 * 静态代理
 * @author admin
 *
 */
public class Assistant implements Play {
	
	private Actor actor;// 代理的目标对象

	public Assistant(Actor actor) {
		this.actor = actor;
	}
	@Override
	public void sing(String songName) {
		System.out.println("欢迎歌星："+actor.getName()+"给我们演唱歌曲："+songName);
		actor.sing(songName);//歌星唱歌
		System.out.println("演唱结束，大家掌声在哪里");
	}

	@Override
	public void dance(String danceName) {
		System.out.println("欢迎歌星："+actor.getName()+"给我们表演："+danceName);
		actor.dance(danceName);
		System.out.println("舞蹈表演结束，大家掌声在哪里");
	}

}
