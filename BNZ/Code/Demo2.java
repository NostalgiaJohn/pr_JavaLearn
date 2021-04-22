class Demo2 {
	public static void main(String[] args) {
		int num = 10;
		
		// 先执行该语句(打印语句)，再执行自增操作
		System.out.println("num++ : " + num++); // 10 
		System.out.println("num : " + num); // 11
		
		// 效果同上
		System.out.println("num : " + num); // 11 
		num++;
		System.out.println("num : " + num); // 12
		
		// 先执行自增操作，再执行该语句(打印语句)
		System.out.println("num++ : " + ++num); // 13
		System.out.println("num : " + num); // 13
	}
}