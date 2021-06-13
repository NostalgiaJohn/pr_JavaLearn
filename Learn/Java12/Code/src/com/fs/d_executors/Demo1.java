package com.fs.d_executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyThread1 implements Runnable {
	@Override
	public void run() {
		System.out.println("Runnable接口实现类，线程目标代码");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(Thread.currentThread().getName() + "明天吃土豆牛肉");
	}
}

public class Demo1 {
	public static void main(String[] args) {
		// 1. 创建线程对象
		ExecutorService service = Executors.newFixedThreadPool(5);
		
		// 2. 创建一个MyThread1 Runnable接口实现类对象
		MyThread1 target = new MyThread1();
		
		// 3. 使用线程池对象中的一个线程，制定目标代码
		// 初始化线程数为5，这里使用的是线程池中已经存在的5个线程来执行代码
		service.submit(target);
		service.submit(target);
		service.submit(target);
		service.submit(target);
		service.submit(target);
		
		// 因为5个线程都在使用中，这里等待执行完毕，出现空闲线程来执行对应代码
		service.submit(target);
		service.submit(target);
		
		// 4. 关闭线程池
		// 一般不用关闭线程池，会随着程序的退出而关闭
		// services.shutdown();
	}
}
