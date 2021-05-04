package com.fs.d_anonymousObject;

class SingleDog{
	String name;

	public SingleDog() {}

	public SingleDog(String name) {
		this.name = name;
	}
	
	public void test() {
		System.out.println("SingleDog类成员方法");
	}
}

public class Demo {
	public static void main(String[] args) {
		SingleDog singleDog = new SingleDog();
		
		singleDog.name = "一";
		singleDog.test();
		
		// 匿名对象直接调用类内的成员方法
		new SingleDog().test();
		new SingleDog().name = "二";
		System.out.println(new SingleDog().name);
		
		// 这里可以传入一个SingleDog对象
		testObject(singleDog);
		// 传入一个匿名对象作为方法的参数
		testObject(new SingleDog());
		
		/*
		 * 串联方式--得到缓冲数据类；后面补充
		 * BufferedInputStream bufferedInputStream = new BufferedInputStream( 
		 * 	new FileInputStream( new File("C:/aa/1.txt")));
		 */
	}
	
	/**
	 * 测试方法
	 * @param singleDog 需要一个SingleDog单身狗对象
	 */
	public static void testObject(SingleDog singleDog) {
//		System.out.println(singleDog);
	}
}
