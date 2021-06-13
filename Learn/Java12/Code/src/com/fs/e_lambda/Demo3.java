package com.fs.e_lambda;

interface A {
	float add(int num1, float num2);
}

public class Demo3 {
	public static void main(String[] args) {
		System.out.println(new A() {

			@Override
			public float add(int num1, float num2) {
				return num1 + num2;
			}
		}.add(5, 13.5F));
		
		/*
		 * 1. 不同数据类型也可以省略
		 * 2. 实现代码不止一行，可以在大括号内完成
		 */
		test(5, 16.5F, (num1, num2) -> {
			float sum = num1 + num2;
			return sum;
		});
		
	}

	private static void test(int num1, float num2, A a) {
		System.out.println(a.add(num1, num2));
	}
}
