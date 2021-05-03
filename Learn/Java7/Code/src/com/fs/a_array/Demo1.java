package com.fs.a_array;

/*
 * 二分法查找
 */
public class Demo1 {
	public static void main(String[] args) {
		int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
		
		int halfSearch = halfSearch(arr, 13);
		System.out.println(halfSearch);
	}
	
	/*
	 * 方法分析：
	 * 		public static 不要问
	 * 		返回值类型：
	 * 			int
	 * 		方法名:
	 * 			halfSearch
	 * 		形式参数列表:
	 * 			(int[] sortedArray, int find)
	 * 方法声明：
	 * 		public static int halfSearch(int[] sortedArray, int find)
	 */
	/**
	 * 二分法查找算法
	 * 
	 * @param sortedArray 这里要求是一个int类型数组，并且是进过排序之后的升序数组
	 * @param find 需要查询的元素
	 * @return 返回值大于等于0找到元素下标位置，没有找返回-1
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





