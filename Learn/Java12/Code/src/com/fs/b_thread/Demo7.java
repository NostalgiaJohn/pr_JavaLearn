package com.fs.b_thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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
class SingleThread3 implements Runnable {
	
	// 共享资源
	private static int ticket = 100;
	
	// 定义一个成员变量 需要唯一对象
	Lock lock = new ReentrantLock(); 
	// 静态也可以 main方法中可以新三个对象
	//	static Lock lock = new ReentrantLock(); 
	
	@Override
	public void run() {

		while (true) {
			
			// lock对象加锁
			lock.lock();
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
				break;
			}
			
			// 解除锁
			lock.unlock();
		}
	}
}

public class Demo7 {
	public static void main(String[] args) {
		SingleThread3 singleThread3 = new SingleThread3();
		Thread thread1 = new Thread(singleThread3, "淘票票");
		Thread thread2 = new Thread(singleThread3, "美团");
		Thread thread3 = new Thread(singleThread3, "猫眼");
		
		thread1.start();
		thread2.start();
		thread3.start();
		
	}
}
