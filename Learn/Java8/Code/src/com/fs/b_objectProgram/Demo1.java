package com.fs.b_objectProgram;

/**
 * main ����������
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
		System.out.println("���Ի���");
		
		computer.computerRunning();
		Thread.sleep(500);
		
		// ͨ���������󣬵���������Եķ���
		// ��Ҫ�Ĳ�����Computer�����
		new Repair().repair(computer);
		
		for (int i = 0; i < 5; i++) {
			computer.computerRunning();
			Thread.sleep(500);
		}
	
	}
}
