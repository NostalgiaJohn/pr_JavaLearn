package com.fs.a_array;

/**
 * 
 * @author fStardust
 *
 */
public class Demo {
	public static void main(String[] args) {
		int[] arr = {1, 5, 3, 4534, 3, 4, 6};
		
		allIndexOf(arr, 2);
	}
	
	/*
	 * Ҫ��
	 * 	����ָ��Ԫ���������е������±�
	 * ����������
	 * 	public static
	 * 	����ֵ
	 * 		û������������ֱ���ڷ����д�ӡԪ�������±�
	 * 		void
	 * 	������
	 * 		allIndexOf
	 * 	��ʽ�����б�
	 * 		Դ�������飬ָ��Ԫ��
	 * 		(int[] arr, int find)
	 * ����������
	 * 	public static void allIndexOf(int[] arr, int find)
	 */
	/**
	 * ��ʵ�ַ���ָ��Ԫ���������е������±�
	 * 
	 * @param arr
	 * @param find
	 */
	public static void allIndexOf(int[] arr, int find) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == find) {
				System.out.println(i);
				count += 1;
			}
		}
		if (count == 0) {
			System.out.println("û�и�ֵ");
		}
	}
}