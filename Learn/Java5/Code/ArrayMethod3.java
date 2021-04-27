class ArrayMethod3 {
	public static void main(String[] args) {
		int[] arr = {1,3,453};
		
		int index = indexOf(arr,324);
		if (index >= 0) {
			System.out.println("index:" + index);
		} else {
			System.out.println("Not Found");
		}
		
	}
	/**
	* 找出指定数组中，指定元素的下标位置，并通过返回值返回
	* 
	* @param arr 指定的int类型数据数组
	* @param find 指定需要查询的数据
	* @return 返回值大于等于0；-1表示未找到对应数据
	*/
	public static int indexOf(int[] arr, int find) {
		
		int index = -1;
		for (int i = 0; i < arr.length; i++) {
			if (find == arr[i]) {
				index = i;
				break;
			}
		}
		
		return index;
	}
}