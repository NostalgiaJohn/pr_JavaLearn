package com.fs.a_api;

/*
 * 包装类演示
 */
public class Demo7 {
	public static void main(String[] args) {
		byte parseByte = Byte.parseByte("1");
		Short parseShort = Short.parseShort("123");

		boolean parseBoolean = Boolean.parseBoolean("true");
		
		System.out.println(parseBoolean);
		
		// 传入的字符串无法解析对应的数据-NumberFormatException
		System.out.println(Integer.parseInt("123a"));
	}
	/*
	 * 包装类自动装拆箱过程
	 */
	private static void Test1() {
		// 自动方式
		// 基本数据类型
		int num = 5;
		
		// 基本数据类型赋值给包装类，自动装箱过程
		Integer num1 = num;
		System.out.println(num1);
		
		// 包装类转换成基本数据类型，自动拆箱过程
		int num2 = num1;
		System.out.println(num2);
		
		// 强行包装
		Integer i = new Integer(5);
		Integer ii = Integer.valueOf(5);
		
		// 强行拆箱
		int intValue = i.intValue();
	}
}
