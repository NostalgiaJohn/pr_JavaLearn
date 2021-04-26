class Demo2 {
	public static void main(String[] args) {
		// 定义一个int类型数据
		int[] arr = new int[10];
		
		// 使用for循环对于数组中的每一个进行赋值操作
		for (int i = 0; i < arr.length; i++) {
			// i是循环变量，从0~9
			arr[i] = i + 1;
			
		}
		
		// 使用for循环对于数组中的元素进行取值展示操作
		for (int i = 0; i < arr.length; i++) {
			System.out.println("arr[" + i + "]=" + arr[i]);
		}
	}
}