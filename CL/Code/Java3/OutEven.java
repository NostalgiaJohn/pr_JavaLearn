// 输出0-100中的偶数

class OutEven {
	public static void main(String[] args) {
		/*
		循环执行了101次
		判断执行了101次
		单位时间消耗--202次
		*/
		for (int i = 0; i <= 100; i++) {
			if (i % 2 == 0) {
				System.out.println(i);
			}
		}
		
		System.out.println();
		/*
		循环执行了51次
		无判断执行
		单位时间消耗--51次
		*/
		for (int i = 0; i <= 100; i += 2 ) {
			System.out.println(i);
		}
	}
}