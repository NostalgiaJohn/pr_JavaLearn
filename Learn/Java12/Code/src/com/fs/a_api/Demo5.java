package com.fs.a_api;

import java.util.Arrays;
import java.util.Properties;

/*
 * System类演示
 */
public class Demo5 {
	public static void main(String[] args) {
		// 获取系统时间戳
		long time = System.currentTimeMillis();
		System.out.println(time);
		System.out.println("----------------");
		
		// 属性类
		Properties properties = System.getProperties();
		properties.list(System.out);
		System.out.println("----------------");
		
		// 可以获取系统对应属性的数据
		String property = System.getProperty("os.name");
		System.out.println(property);
		System.out.println("----------------");
		
		// 数组拷贝
		int[] arr = {1, 3, 5, 7, 9, 2, 4, 6, 8, 0};
		int[] temp = new int[10];
		System.arraycopy(arr, 0, temp, 0, arr.length);
		System.out.println(Arrays.toString(temp));
		System.out.println("----------------");
		
		// 退出整个程序：0为正常退出
		// exit code: 0 or -1
		System.exit(0);
		
	}
}
