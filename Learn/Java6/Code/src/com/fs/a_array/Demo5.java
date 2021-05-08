package com.fs.a_array;

import java.util.Arrays;

public class Demo5 {
	public static void main(String[] args) {
		int[] arr = {1, 3, 5, 7, 9, 2, 4, 6, 8, 10};
		System.out.println(Arrays.toString(arr));
		
		selectSort(arr);
		
		System.out.println(Arrays.toString(arr));
	}
	
	/*
	 * ѡ�������㷨
	 * ����������
	 * 	public static
	 * 	����ֵ��
	 * 		void
	 * 	��������
	 * 		selectSort
	 * 	��ʽ�����б���
	 * 		��Ҫ����һ��int��������
	 * 		(int[] arr)
	 * 
	 * ���������
	 * 	ֻ�轫�þ��е�< ��Ϊ> ����
	 * 		if (arr[index] < arr[j])
	 * 
	 *����������
	 *	public static void selectSort(int[] arr)
	 */
	/**
	 * ѡ�������㷨
	 * 
	 * @param arr ��Ҫ���������int��������
	 */
	public static void selectSort(int[] arr) {
		// ���ѭ�����ƺ����㷨��ѭ������
		for (int i = 0; i < arr.length - 1; i++) {
			// ��index��ʼ��Ѱ��ֵ
			int index = i;
			
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[index] < arr[j]) {
					index = j;
				}
			}
			
			if (index != i) {
				int temp = arr[i];
				arr[i] = arr[index];
				arr[index] = temp;
			}
		}
	}
}