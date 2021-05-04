package com.fs.b_objectProgram;

/**
 * main 方法所在类
 * @author fStardust
 *
 */
public class Demo1 {
	public static void main(String[] args) throws InterruptedException {
		Computer computer = new Computer(true);
		
		for (int i = 0; i < 5; i++) {
			computer.computerRunning();
			Thread.sleep(500);
		}
		
		computer.setScreenShow(false);
		System.out.println("电脑坏了");
		
		computer.computerRunning();
		Thread.sleep(500);
		
		// 通过修理店对象，调用修理电脑的方法
		// 需要的参数是Computer类对象
		new Repair().repair(computer);
		
		for (int i = 0; i < 5; i++) {
			computer.computerRunning();
			Thread.sleep(500);
		}
	
	}
}
