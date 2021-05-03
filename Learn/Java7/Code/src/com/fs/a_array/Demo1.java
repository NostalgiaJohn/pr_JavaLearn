package com.fs.a_array;

/*
 * ���ַ�����
 */
public class Demo1 {
	public static void main(String[] args) {
		int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
		
		int halfSearch = halfSearch(arr, 13);
		System.out.println(halfSearch);
	}
	
	/*
	 * ����������
	 * 		public static ��Ҫ��
	 * 		����ֵ���ͣ�
	 * 			int
	 * 		������:
	 * 			halfSearch
	 * 		��ʽ�����б�:
	 * 			(int[] sortedArray, int find)
	 * ����������
	 * 		public static int halfSearch(int[] sortedArray, int find)
	 */
	/**
	 * ���ַ������㷨
	 * 
	 * @param sortedArray ����Ҫ����һ��int�������飬�����ǽ�������֮�����������
	 * @param find ��Ҫ��ѯ��Ԫ��
	 * @return ����ֵ���ڵ���0�ҵ�Ԫ���±�λ�ã�û���ҷ���-1
	 */
	public static int halfSearch(int[] sortedArray, int find) {
		int minIndex = 0;
		int maxIndex = sortedArray.length - 1;
		int mid = (minIndex + maxIndex) / 2;
		
		while (minIndex <= maxIndex ) {
			if (sortedArray[mid] > find) {
				maxIndex = mid - 1;
			} else if(sortedArray[mid] < find) {
				minIndex = mid + 1;
			} else {
				return mid;
			}
			mid = (minIndex + maxIndex) / 2;
		}
		
		return -1;
	}
}





