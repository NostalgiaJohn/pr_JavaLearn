package com.fs.b_thread;

/*
 * 共享资源冲突问题
 */

/**
 * 自定义售票线程类
 * 使用非静态成员同步方法，需要满足有且只有一个当前类对象
 * 
 * @author fStardust
 *
 */
class SingleThread1 implements Runnable {
	
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
	 * 完成一个同步方法，该方法是一个非静态成员方法
	 * 锁对象就是this.当前类
	 */
	public synchronized void sellTicket() {
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

public class Demo5 {
	public static void main(String[] args) {
		SingleThread1 singleThread1 = new SingleThread1();
		Thread thread1 = new Thread(singleThread1, "淘票票");
		Thread thread2 = new Thread(singleThread1, "美团");
		Thread thread3 = new Thread(singleThread1, "猫眼");
		
		thread1.start();
		thread2.start();
		thread3.start();
		
	}
}
