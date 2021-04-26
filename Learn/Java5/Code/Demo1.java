class Demo1 {
	public static void main(String[] args) {
		// 定义一个int类型的数组
		int[] arr = new int[10];
		
		// 首先赋值数组中下标为0,5的元素
		// 数组名[有效下标] = 赋予的数据;
		arr[0] = 10;
		arr[5] = 20;
		
		/*
		所有负数对于数组而言都是非法下标
		Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: -1
        at Demo1.main(Demo1.java:11)
		*/
		// arr[-1] = 5;
		
		arr[10] = 20;
		
		// 可以取值
		System.out.println("arr[0]:" + arr[0]);
		System.out.println("arr[5]:" + arr[5]);
	}
}