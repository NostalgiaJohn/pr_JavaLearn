package com.fs.b_anonymous;

/*
 * 匿名内部类演示
 */

interface A {
	void test();
}

/**
 * 非abstract修饰TypeA遵从接口A，要求强制实现接口A中的test方法
 * 
 * @author fStardust
 *
 */
class TypeA implements A {

	@Override
	public void test() {
		System.out.println("TypeA遵从A接口，实现A接口中的test方法");
	}
}

public class Demo1 {
	public static void main(String[] args) {
		TypeA typeA = new TypeA();
		typeA.test();
		
		/*
		 *  A接口的引用
		 *  new调用A接口的构造方法
		 *  【注意】这里不是创建A接口对象
		 *  Anonymous Inner Type提示是完成了一个遵从接口A必须实现的方法
		 *  
		 *   {} 中的内容和一个普通类遵从接口A的效果是一模一样的
		 *   {} 中的内容可以认为是【类的本体】
		 *   但是{} 之前没有类名，这就是匿名内部类
		 *   
		 *   
		 *   new关键字在内存堆区申请了空间，创建了一个隐含遵从接口A的匿名内部类对象
		 *   并且把该对象的空间首地址，赋值给接口A的引用数据类型变量
		 *   接口的引用指向遵从接口的类对象，就是多态！
		 */
		// 这样操作有些麻烦--low
		A a = new A() {
			
			@Override
			public void test() {
				System.out.println("匿名内部类的对象赋值给接口的引用");
				
			}
		};
		
		a.test();
		
		// 匿名内部类的匿名对象直接调用实现方法 但这种方法效率也不高--litter low
		new A() {
			
			@Override
			public void test() {
				System.out.println("匿名内部类的匿名对象直接调用实现方法");
				
			}
		}.test();
		
		// 匿名内部类的匿名对象直接作为方法的参数-- 最常用的方式/终极奥义
		testInterface(new A() {

			@Override
			public void test() {
				System.out.println("匿名内部类的匿名对象直接作为方法的参数");
			}
			
		});
	}
	
	/**
	 * 
	 * @param a
	 */
	public static void testInterface(A a) {
		a.test();
	}
}
