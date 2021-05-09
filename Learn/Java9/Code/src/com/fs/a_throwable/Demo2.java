package com.fs.a_throwable;

/*
 * 抛出异常总结:
 * 		1. 一个代码块内，有且只能抛出一个异常
 * 		2. 从throw位置开始，之后的代码不在运行
 * 		3. 代码中存在使用throw抛出异常，在方法的声明位置必须告知调用者这里有什么异常
 */
public class Demo2 {
	// 调用带有异常抛出的方法，
	// 如果选择继续抛出需要在当前方法的声明位置告知其他调用者，这里有什么异常抛出
	public static void main(String[] args) 
			throws ArithmeticException , NullPointerException {
		// 调用一个带有异常抛出的方法
		// 捕获处理
		try {
			test(10, 2, null);
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}
		
		// 可以继续抛出异常
		test(10, 0, null);
	}
	
	/**
	 * 测试方法
	 * 
	 * @param num1 int类型
	 * @param num2 int类型
	 * @param arr int类型数组
	 * @throws ArithmeticException 除数不能为0
	 * @throws NullPointerException 操作数组null地址异常
	 */
	public static void test(int num1, int num2, int[] arr) 
			throws ArithmeticException , NullPointerException {
		// 参数合法性判断
		/*
		 * if (0 == num2 || null == arr) {
		 * System.out.println("Input Parameter is Invalid!");
		 * return;}
		 */
		// 抛出异常方式来处理当前参数合法性判断
		if (0 == num2) {
			// 有可能会导致算术异常
			throw new ArithmeticException("算术异常");
		}
		
		if (null == arr) {
			// 有可能会导致算术异常
			throw new NullPointerException("算术异常");
		}
		
		System.out.println(num1 / num2);
		arr[0] = 10;
	}
}
