class ArrayMethod4 {
	public static void main(String[] args) {
		int[] arr = {1,23,4,534,87};
		System.out.println(get(arr, 2));
	}
	/**
	* 找出数组指定下标的元素
	* 
	* @param arr 指定的int类型数组
	* @param int 指定查询的下标位置
	* @return 返回对应下标的元素
	*/
	public static int get(int[] arr, int index) {
		if (index < 0 || index > arr.length - 1) {
			System.out.println("Input Parameter is Invalid");
			System.exit(0); // 退出方法
		}
		
		return arr[index];
	}
	
}