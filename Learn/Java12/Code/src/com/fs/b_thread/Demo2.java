package com.fs.b_thread;

public class Demo2 {
	public static void main(String[] args) {
		Thread thread1 = new Thread();
		Thread thread2 = new Thread("a线程");
		
		// 给予Thread类构造方法Runnable接口实现类对象
		Thread thread3 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("匿名内部类对象作为线程的执行目标");
			}
		});
		
		// 给予Thread类构造方法Runnable接口实现类对象，并且约定名字
		Thread thread4 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Anonymous Inner Type");
			}
		}, "匿名内部类对象");
		
		System.out.println(thread1);
		System.out.println(thread2);
		System.out.println(thread3);
		System.out.println(thread4);

		/*
		Thread[Thread-0,5,main]
		Thread[a线程,5,main]
		Thread[Thread-1,5,main]
		Thread[匿名内部类对象,5,main]
		
		Thread[ThreadNeam, ThreadPriority, ThreadGroup]
		 */
	}
}
