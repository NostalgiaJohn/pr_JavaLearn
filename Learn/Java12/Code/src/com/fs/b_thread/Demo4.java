package com.fs.b_thread;

/*
 * 共享资源冲突问题
 */

/**
 * 自定义售票线程类
 * 
 * @author fStardust
 *
 */
class SingleThread implements Runnable {
	
	// 共享资源
	private static int ticket = 100;
	
	
	@Override
	public void run() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (true) {
			if (ticket > 0) {
				System.out.println(Thread.currentThread().getName() + "售出了" + ticket + "张票");
				ticket -= 1;
			} else {
				System.out.println(Thread.currentThread().getName() + "售罄！");
				break;
			}
		}
	}
}

public class Demo4 {
	public static void main(String[] args) {
		Thread thread1 = new Thread(new SingleThread(), "淘票票");
		Thread thread2 = new Thread(new SingleThread(), "美团");
		Thread thread3 = new Thread(new SingleThread(), "猫眼");
		
		thread1.start();
		thread2.start();
		thread3.start();
		
	}
}
