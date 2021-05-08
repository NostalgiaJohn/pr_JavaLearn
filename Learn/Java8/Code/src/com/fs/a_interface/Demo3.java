package com.fs.a_interface;

/*
 * JDK1.8 新特征
 */
interface F {
	/*
	 * 接口中默认方法
	 * default
	 * default修饰的方法是有方法体的
	 * 	1. 接口提供最基本的处理方式
	 * 	2. 非强制实现方法，可选完成
	 */
	default void testF() {
		System.out.println("接口中的默认方法，非强制");
	}
}

class TypeC implements F {
	
}
public class Demo3 {
	public static void main(String[] args) {
		new TypeC().testF();
	}
}
