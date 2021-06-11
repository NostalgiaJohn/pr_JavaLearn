package com.fs.c_thread;
/**
 * Goods 商品
 * @author fStardust
 *
 */
public class Goods {
	private String name;
	private float price;
	private boolean product;
	
	public Goods() {}

	public Goods(String name, float price, boolean product) {
		super();
		this.name = name;
		this.price = price;
		this.product = product;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public boolean isProduct() {
		return product;
	}

	public void setProduct(boolean product) {
		this.product = product;
	}
}