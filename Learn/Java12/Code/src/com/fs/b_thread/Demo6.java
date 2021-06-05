package com.fs.b_thread;

/*
 * 共享资源冲突问题
 */

/**
 * 自定义售票线程类
 * 使用静态同步成员方法来完成线程同步方法
 * 
 * @author fStardust
 *
 */
class SingleThread2 implements Runnable {
	
	// 共享资源
	private static int ticket = 100;
	
	@Override
	public void run() {

		while (true) {
			/*
			 * 调用一个同步方法
			 */
			sellTicket();
			
			if (0 == ticket) {
				break;
			}
		}
	}
	
	/**
	 * 完成一个static修饰的静态同步成员方法
	 * 锁对象是当前类名.class 是唯一的
	 */
	public static synchronized void sellTicket() {
		if (ticket > 0) {
			System.out.println(Thread.currentThread().getName() + "售出了" + ticket + "张票");
			ticket -= 1;
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else {
			System.out.println(Thread.currentThread().getName() + "售罄！");
		}
	}
}

public class Demo6 {
	public static void main(String[] args) {
		Thread thread1 = new Thread(new SingleThread2(), "淘票票");
		Thread thread2 = new Thread(new SingleThread2(), "美团");
		Thread thread3 = new Thread(new SingleThread2(), "猫眼");
		
		thread1.start();
		thread2.start();
		thread3.start();
		
	}
}
