package com.fs.b_math;

/*
 * Math工具类方法
 */
public class Demo1 {
	public static void main(String[] args) {
		// 绝对值
		System.out.println(Math.abs(1.5));
		System.out.println(Math.abs(-1.5));
		System.out.println(Math.abs(5));
		System.out.println(Math.abs(-5));
	
		System.out.println("--------------------------------");
		
		// 向上取整
		System.out.println(Math.ceil(1.5));
		System.out.println(Math.ceil(1.1));
		System.out.println(Math.ceil(-1.9));
		System.out.println(Math.ceil(-2.9));
		
		System.out.println("--------------------------------");
		
		// 向下取整
		System.out.println(Math.floor(10.5));
		System.out.println(Math.floor(10.1));
		System.out.println(Math.floor(-10.5));
		System.out.println(Math.floor(-10.1));
		
		System.out.println("--------------------------------");
		
		// 四舍五入
		System.out.println(Math.round(3.5)); // 4
		System.out.println(Math.round(3.4)); // 3
		System.out.println(Math.round(-2.5)); // -2
		System.out.println(Math.round(-2.4)); // -2
		System.out.println(Math.round(-2.6)); // -3
	}
}