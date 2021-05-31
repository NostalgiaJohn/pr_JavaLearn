package com.fs.a_api;

/*
 * StringBufferTest
 */
public class Demo1 {
	public static void main(String[] args) {
		// 构造
		StringBuffer stringBuffer1 = new StringBuffer();
		StringBuffer stringBuffer2 = new StringBuffer("吃饭");
		
		System.out.println(stringBuffer1);
		System.out.println(stringBuffer2.toString());
		
		StringBuffer stringBuffer3 = new StringBuffer("萧记烩面，蔡记蒸饺，何记小面");
		
		// 添加
		stringBuffer3.append("油泼面");
		stringBuffer3.append(new Demo1());
		
		System.out.println(stringBuffer3);
		
		StringBuilder stringBuilder = new StringBuilder("ABCD");
		stringBuilder.insert(3, "羊肉汤");
		
		System.out.println(stringBuilder);
		
		// 查找
		System.out.println(stringBuffer3.indexOf("萧记烩面"));
		System.out.println(stringBuffer3.substring(3));
		System.out.println(stringBuffer3.length());
		
		stringBuffer3.replace(0, 1, "武汉小面");
		System.out.println(stringBuffer3);
		
		// 删除和逆序 
		stringBuffer3.delete(1, 4);
		System.out.println(stringBuffer3);
		
		stringBuffer3.reverse();
		System.out.println(stringBuffer3);
	}
}
