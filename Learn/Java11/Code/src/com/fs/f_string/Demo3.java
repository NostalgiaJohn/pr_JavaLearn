package com.fs.f_string;

import java.util.Arrays;

public class Demo3 {
	public static void main(String[] args) {
		System.out.println("字符串获取法----------------------------");
		String str = "土豆牛肉土豆牛肉";
		
		System.out.println("str.length() : " + str.length());
		System.out.println("str.charAt(0) : " + str.charAt(0));
		// System.out.println("str.charAt(0) : " + str.charAt(4));
		
		System.out.println("str.indexOf('土') : " + str.indexOf('土'));
		System.out.println("str.indexOf('面') : " + str.indexOf('面'));
		System.out.println("str.indexOf(\"土豆\") : " + str.indexOf("土豆"));
		System.out.println("str.indexOf(\"油泼面\") : " + str.indexOf("油泼面"));
		
		System.out.println("str.indexOf('土', 2) : " + str.indexOf('土', 2));
		System.out.println("str.indexOf('面', 2) : " + str.indexOf('面', 2));
		
		System.out.println("str.lastIndexOf('土') : " + str.lastIndexOf('土'));
		System.out.println("str.lastIndexOf('面') : " + str.lastIndexOf('面'));
		System.out.println("str.lastIndexOf(\"土豆\") : " + str.lastIndexOf("土豆",3));
		System.out.println("str.lastIndexOf(\"油泼面\") : " + str.lastIndexOf("油泼面"));
		
		System.out.println("str.indexOf('土', 2) : " + str.indexOf('土', 2));
		System.out.println("str.indexOf('面', 2) : " + str.indexOf('面', 2));
		
		
		System.out.println("字符串判断方法----------------------------");
		
		String str1 = "红烧茄子";
		
		boolean ret = str1.endsWith("茄子");
		System.out.println(ret);
		
		boolean ret2 = str1.isEmpty();
		System.out.println(ret2);
		System.out.println("".isEmpty());
		
//		String str = null;
//		System.out.println(str.isEmpty());
		
		System.out.println("ABCDEFG".contains("AB"));
		
		System.out.println("Abcdefg".equals("ABCDEFG"));
		System.out.println("Abcdefg".equalsIgnoreCase("ABCDEFG"));
		
		System.out.println("字符串转换方法----------------------------");
		
		char[] arr = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'};
		
		String str4 = new String(arr);
		System.out.println(str1);
		
		String str5 = new String(arr, 2, 5);
		System.out.println(str5);
		
		String str6 = String.valueOf(arr);
		System.out.println(str6);
		
		String str7 = String.valueOf(arr, 2, 5);
		System.out.println(str7);
		
		char[] charArray = "这个字符串会变成一个字符数组".toCharArray();
		System.out.println(Arrays.toString(charArray));
		
		System.out.println("字符串其他方法----------------------------");
		
		System.out.println("abcdabcdabcd".replace('a', 'A'));
		System.out.println("abcdabcdabcd".replaceAll("ab", "AB"));
		System.out.println("abcdabcdabcd".replaceFirst("ab", "AB"));
		
		String[] split = "A,B,C,D,E,F,G".split(",");
		System.out.println(Arrays.toString(split));
		
		System.out.println("ABCDEFG".substring(2));
		System.out.println("ABCDEFG".substring(2, 5));
		
		System.out.println("abcdefg".toUpperCase());
		System.out.println("ABCDEFG".toLowerCase());
		
		System.out.println("       ABCDEFG        ABCDEFG    ");
		System.out.println("       ABCDEFG        ABCDEFG    ".trim());// 处理标题
		
		System.out.println("补充获取字符串的码点数----------------------------");                                             
		
		String greeting = "Hello";
		String greeting1 = "🚖";
		int cpCount = greeting.codePointCount(0, greeting.length());
		System.out.println("\"Hello\"的字节数为 : " + greeting.length());
		System.out.println("\"Hello\"的码点数为 : " + cpCount);
		int cpCount1 = greeting1.codePointCount(0, greeting1.length());
		System.out.println("\"🚖\"的字节数为 : " + greeting1.length());
		System.out.println("\"🚖\"的码点数为 : " + cpCount1);
		}
}
