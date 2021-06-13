package com.fs.d_executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo2 {
	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(3);
		
		// Runnable匿名内部类的匿名对象作为方法的参数
		service.submit(new Runnable() {

			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + "Runnable匿名内部类的匿名对象作为方法的参数");
			}
		});
		
		// lambda 表达式
		service.submit(() -> System.out.println(Thread.currentThread().getName()));
		service.submit(() -> System.out.println(Thread.currentThread().getName()));
		service.submit(() -> System.out.println(Thread.currentThread().getName()));
	}
}
