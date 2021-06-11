package com.fs.c_thread;

/**
 * Custmor 消费者
 * 
 * @author fStardust
 *
 */
public class Custmor implements Runnable {

	private Goods goods = null;

	public Custmor() {
	}

	public Custmor(Goods goods) {
		this.goods = goods;
	}

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

				// 可以购买
				if (!goods.isProduct()) {
					System.out.println("消费者购买了" + goods.getName() + ":" + goods.getPrice());

					// 修改商品标记
					goods.setProduct(true);

					// 唤醒生产者
					System.out.println("唤醒生产者");
					goods.notify();
				} else {
					System.out.println("消费者进入无限等待状态");
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