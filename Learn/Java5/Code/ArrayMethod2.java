class ArrayMethod2 {
	public static void main(String[] args) {
		int[] arr = {1, 3, 5, 7, 19, 2, 4, 19, 8, 10};
		
 		int index = maxIndexOf(arr);
		System.out.println("index:" + index);
	}
	
	/*
	需求
		从int类型数组中找出对应的最大值下标位置
	方法分析:
		public static 不要问
		返回值类型：
			数组的下标数据类型是int类型
			int
		方法名:
			maxIndexOf
		形式参数列表：
			(int[] arr)
	方法声明：
		public static int maxIndexOf(int[] arr)
	*/

	/**
	* 返回指定int类型数组中最大值的下标位置
	*
	* @param arr int类型数组
	* @return 返回值是最大值所在的下标位置
	*/
	public static int maxIndexOf(int[] arr) {
		// 首先：假定下标为0的元素是数组中最大值
		int maxIndex = 0;
		
		// 因为循环过程中，下标为0的元素没有必要和自己比较
		// 循环变量从1开始
		for (int i = 1; i < arr.length; i++) {
			/*
			如果发现maxIndex保存的下标对应元素，是小于i的
			保存对应的i值
			*/
			if (arr[maxIndex] < arr[i]) {
				maxIndex = i;
			}
		}
		
		return maxIndex;
	}
}

