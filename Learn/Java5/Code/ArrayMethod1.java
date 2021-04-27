import java.util.Arrays;
class ArrayMethod1 {
	public static void main(String[] args) {
		int[] arr = {1,3,4,5,6,7,8,9,1024};
		
		reverse(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	/*
	静态数组
		int[] arr = {1,7,3,5,9};
		逆序完成：
			{9,5,3,7,1}
	方法的分析：
		public static
		返回值类型:
			void
		方法名：
			逆序 reverse
		形式参数列表：
			int[] arr
	方法声明;
		public static void reverse(int[] arr)
	*/

	/**
	* 完成对于int类型数组的逆序过程
	* 
	* @param arr int 类型数组
	*/
	public static void reverse(int[] arr) {
		for (int i = 0; i < arr.length / 2; i++) {
			int temp = 0;
			/*
			arr[0] = arr [9]
			交换
			*/
			temp = arr[i];
			arr[i] = arr[arr.length - 1 -i];
			arr[arr.length - 1 -i] = temp;
		}
	}
}

