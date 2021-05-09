package com.fs.a_throwable;

/*
 * 捕获异常问题总结：
 * 	1. 代码中从异常发生位置开始，之后的代码都不再运行
 * 	2. 代码中有多个异常，可以使用多个catch块进行捕获操作，分门别类处理
 *  3. 当前情况下，只能展示异常情况，后期可以将异常情况做成log日志文件
 *  4. 异常被捕获后代码可以正常运行
 */
public class Demo1 {
	public static void main(String[] args) {
		test(10, 0, null);
	}
	
	public static void test(int num1, int num2, int[] arr) {
		int ret = 0;
		
		try {
			ret = num1 / num2;
			System.out.println("测试代码");
			arr[0] = 10;
		} catch (ArithmeticException e) {
			e.printStackTrace();
			// System.out.println("发生了算术异常");
		} catch (NullPointerException e) {
			e.printStackTrace();
			// System.out.println("发生了空指针异常");
		}
		
		System.out.println("ret:" + ret);
	}
}
