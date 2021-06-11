package com.fs.b_thread;

/**
 * Producer 生产者
 * @author fStardust
 *
 */
class Producer implements Runnable {
	
	private Goods goods = null;
	
	public Producer() {}
	
	public Producer(Goods goods) {
		this.goods = goods;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}

/**
 * Custmor 消费者
 * @author fStardust
 *
 */
class Custmor implements Runnable{

	private Goods goods = null;
	
	public Custmor() {}
	
	public Custmor(Goods goods) {
		this.goods = goods;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}

/**
 * Goods 商品
 * @author fStardust
 *
 */
class Goods {
	
}

public class Demo9 {
	public static void main(String[] args) {
		Goods goods = new Goods();
		
		Producer producer = new Producer(goods);
		Custmor custmor = new Custmor(goods);
	}
}
