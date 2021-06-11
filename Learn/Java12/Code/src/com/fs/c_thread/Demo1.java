package com.fs.c_thread;

public class Demo1 {
	public static void main(String[] args) {
		Goods goods = new Goods();
		
		Producer producer = new Producer(goods);
		Custmor custmor = new Custmor(goods);
		
		new Thread(producer).start();
		new Thread(custmor).start();
		
		/*
		 * 添加wait前：两个线程互相抢，造成某一个经常休眠而另一个又抢不到
		 * 两个线程同时运行，一个线程进入线程代码块，同时加锁，运行结束
		 * 两个线程回到同一起跑线，但是需要保障之前运行过的线程进入休眠状态
		 * 如果已经执行完成的，调用wait方法，进入休眠状态
		 */
	}
}
