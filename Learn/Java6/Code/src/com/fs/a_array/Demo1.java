package com.fs.a_array;

import java.util.Iterator;

public class Demo1 {
	public static void main(String[] args) {
		int[] arr = {3, 545, 1, 345, 32, 10};
		
		int min = minIndexOf(arr);
		System.out.println("min index : " + min);
	}
	/*
	 * 找出数组中最小值所在的下标位置
	 * 
	 * 方法分析：
	 * 		public static
	 * 		返回值类型：
	 * 			返回数据是数组的下标
	 * 			int类型
	 *		方法名：
	 *			minIndexOf
	 *		形式参数列表：
	 *			需要一个int类型数组
	 *			(int[] arr)
	 *方法声明：
	 *		public static int minIndexOf(int[] arr)
	 */
	
	/**
	 * 当前方法是找出int类型数组中最小值所在下标
	 * 
	 * @param arr int类型数组
	 * @return 最小值所在的下标位置
	 */
	public static int minIndexOf(int[] arr) {
		// 假设最小值下标位置是下标为0的元素
		int min = 0;
		
		for (int i = 1; i < arr.length; i++) {
			if (arr[min] > arr[i]) {
				min = i;
			}
		}
		
		return min;
	}
}




