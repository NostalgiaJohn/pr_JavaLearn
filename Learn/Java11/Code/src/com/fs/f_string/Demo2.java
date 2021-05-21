package com.fs.f_string;

/*
 * 字符串比较问题
 */
public class Demo2 {
	public static void main(String[] args) {
		String str1 = "学习";
		String str2 = "学习";
		// 以下两种new String不推荐
		String str3 = new String("学习");
		String str4 = new String(str1);
		
		System.out.println("str1 == str2 : " + (str1 == str2));
		System.out.println("str1 == str4 : " + (str1 == str4));
		System.out.println("str2 == str3 : " + (str2 == str3));
		System.out.println("str3 == str4 : " + (str3 == str4));
		
		System.out.println("-----------------------------------");
		
		// 无论什么时候字符串比较有且只能使用equals方法
		System.out.println("str1.equals(str2) : " + str1.equals(str2));
		System.out.println("str1.equals(str4) : " + str1.equals(str4));
		System.out.println("str2 == str3 : " + str2.equals(str3));
		System.out.println("str3 == str4 : " + str3.equals(str4));
	}
}
