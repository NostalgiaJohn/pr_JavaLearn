package com.fs.c_thread;

/**
 * Producer 生产者
 * 
 * @author fStardust
 *
 */
public class Producer implements Runnable {

	private Goods goods = null;

	public Producer() {
	}

	public Producer(Goods goods) {
		this.goods = goods;
	}

	/*
	 * THread 线程代码
	 */
	@Override
	public void run() {
		while (true) {
			synchronized (goods) {
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				if (goods.isProduct()) {
					if (Math.random() > 0.5) {
						goods.setName("和饺子馅");
						goods.setPrice(6.0F);
					} else {
						goods.setName("烤羊排");
						goods.setPrice(138);
					}

					// 修改标记
					goods.setProduct(false);
					System.out.println("生产者生产了" + goods.getName() + ":" + goods.getPrice());

					// 唤醒消费者
					System.out.println("唤醒消费者");
					goods.notify();
					
				} else {
					System.out.println("生产者进入无限等待状态");
					try {
						goods.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
}
