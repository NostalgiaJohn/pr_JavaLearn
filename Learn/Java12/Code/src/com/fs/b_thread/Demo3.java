package com.fs.b_thread;

/*
 * Thread类成员方法
 */

class MyThread3 implements Runnable {
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++ )  {
			// MyThread3线程对象
			Thread.currentThread();
			try {
				/*
				 * 这里只能捕获异常不能抛出的原因：
				 * run方法是实现/重写Runnable接口/Thread类内方法
				 * 重写方法要求：方法声明必须和接口或者父类一致
				 * Runnable接口和Thread类内run方法都没有进行任何的抛出操作
				 * 子类重写run方法也不能抛出，保障声明一致
				 * 
				 * @Override注解，要求饭吗严格格式检查
				 */
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("自定义线程");
		}
	}
}

public class Demo3 {
	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("线程目标代码");
			}
		}, "a线程");
		
		// main线程
		Thread currentThread = Thread.currentThread();
		
		System.out.println(thread.getName());
		thread.setName("匿名线程");
		System.out.println(thread.getName());
		
		Thread.sleep(1000);
		
		System.out.println(thread.getPriority());
		/*
		 * Thread.MAX_PRIORITY --最大优先级10
		 * Thread.NORM_PRIORITY --默认优先级5
		 * Thread.MIN_PRIORITY --最小优先级1
		 */
		thread.setPriority(Thread.MAX_PRIORITY);
		System.out.println(thread.getPriority());
		
		
	}
}
