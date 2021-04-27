class Demo4{
	public static void main(String[] args) {
		int[] array = new int[10];
		
		// 调用赋值数组中元素的方法
		// 调用参数是一个数组类型的方法，需要传入的内容是数组名
		assignIntArray(array);
		printIntArray(array);
	}
	
	/*
	需求：
		赋值一个int类型数组
	方法分析：
		public static
		返回值类型:
			void 无返回值
		方法名：
			assignIntArray
		形式参数列表;
			需要一个int类型数组
			(int[] arr)
	方法声明：
		public static void assignIntArray(int[] arr)
	*/
	/**
	* 赋值一个指定的int类型数组
	* 
	* @param arr 这里需要的参数是一个int类型数组
	*/
	public static void assignIntArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}
	}
	
	/*
	需求：
		展示一个int类型数组中保存的数据
	方法分析：
		public static
		返回值类型:
			void 无返回值
		方法名：
			printIntArray
		形式参数列表;
			展示一个int类型数组中保存的数据
			(int[] arr)
	方法声明：
		public static void printIntArray(int[] arr)
	*/
	/**
	* 展示一个int类型数组中保存的数据
	* 
	* @param arr 这里需要一个int类型数组
	*/
	public static void printIntArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println("array[" + i +"]=" + arr[i]);
		}
	}
	
}
