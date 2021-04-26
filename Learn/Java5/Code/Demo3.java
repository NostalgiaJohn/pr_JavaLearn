class Demo3 {
	public static void main(String[] args) {
		int[] arr1 = new int[10];
		int[] arr2 = new int[10];
		
		arr1[5] = 100;
		arr2[5] = 500;
		
		System.out.println(arr1[5]);
		System.out.println(arr2[5]);
		
		arr1 = arr2;
		arr1[5] = 2000;
		
		System.out.println(arr1[5]);
		System.out.println(arr2[5]);
	}
}