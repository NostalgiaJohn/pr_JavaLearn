package com.fs.h_static;

import java.util.Arrays;

/**
 * 自定义数组工具类
 * 工具类当中大多数方法，都是静态方法
 * 
 * @author fStardust
 *
 */
class MyArrays {
	/**
	 * 数组工具类，数组逆序方法
	 * 
	 * @param arr 这里需要一个int类型数组
	 */
	public static void reverse(int[] arr) {
		for (int i = 0; i < arr.length / 2; i++) {
			int temp = arr[i];
			arr[i] = arr[arr.length - 1 - i];
			arr[arr.length - 1 - i] = temp;
			
		}
	}
}
public class Demo1 {
	public static void main(String[] args) {
		int[] arr = {1,3,4,56,8};
		
		MyArrays.reverse(arr);
		
		System.out.println(Arrays.toString(arr));
	}
}
