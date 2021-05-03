package com.fs.a_object;

class SingleDog {
	public SingleDog() {
		System.out.println("Constructor:" + this);
	}
	
	public void test() {
		System.out.println("Method Called:" + this);
	}
}
/*
 * this关键字表示调用当前方法的类对象，或者是当前构造方法中初始化的类对象
 */
public class Demo4 {
	public static void main(String[] args) {
		SingleDog singleDog = new SingleDog();
		
		System.out.println("Instance" + singleDog);
		singleDog.test();
	}
}
