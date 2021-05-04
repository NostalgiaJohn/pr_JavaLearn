package com.fs.b_objectProgram;
/**
 * 修理店类
 * @author fStardust
 *
 */
public class Repair {
	private String name;
	private String addr;
	private String tele;
	
	public Repair() {}

	public Repair(String name, String addr, String tele) {
		this.name = name;
		this.addr = addr;
		this.tele = tele;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getTele() {
		return tele;
	}

	public void setTele(String tele) {
		this.tele = tele;
	}
	
	/*
	 * 核心业务修电脑
	 * 方法分析：
	 * 	public 公开的
	 * 	返回值类型：
	 * 		void
	 * 	形式参数列表:
	 * 		这里需要修理的是电脑，需要外来数据
	 * 		即Computer类对象
	 * 		(Computer computer)
	 * 方法声明：
	 * 	public void repair(Computer computer)
	 */
	/**
	 * 修理店修理电脑的方法，需要的参数是一个外来的电脑对象
	 * 
	 * @param computer Computer类对象是一台电脑
	 * @throws InterruptedException 
	 */
	public void repair(Computer computer) throws InterruptedException {
		if (false == computer.isScreenShow()) {
			System.out.println("修理中...");
			Thread.sleep(2000);
			
			// 修理完电脑，改变电脑状态
			computer.setScreenShow(true);
			System.out.println("修理完毕，付钱");
		} else {
			System.out.println("没坏你来修啥？");
		}
	}
}
