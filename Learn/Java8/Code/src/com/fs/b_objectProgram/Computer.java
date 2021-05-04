package com.fs.b_objectProgram;
/**
 * 电脑类
 * 
 * @author fStardust
 *
 */
public class Computer {
	// 成员变量--屏幕是否ok
	private boolean screenShow;
	
	public Computer() {}
	
	public Computer(boolean screenShow) {
		this.screenShow = screenShow;
	}

	public boolean isScreenShow() {
		return screenShow;
	}

	public void setScreenShow(boolean screenShow) {
		this.screenShow = screenShow;
	}



	/*
	 * 判断当前屏幕是否ok，ok可以看直播，如果不ok，则不能看直播
	 */
	public void computerRunning() {
		// 判断电脑屏幕状态
		if(screenShow) {
			System.out.println("学Java");
		} else {
			System.out.println("无法学Java...修电脑");
		}
		
	}
}
