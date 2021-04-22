class Demo2 {
	public static void main(String[] args) {
		int num = 10;
		
		// 先执行该语句(打印语句)，再执行自增操作
		System.out.println("num++ : " + num++); // 10 
		System.out.println("num : " + num); // 11
		
		// 先执行自增操作，再执行该语句(打印语句)
		System.out.println("num++ : " + ++num); // 12
		System.out.println("num : " + num); // 12
	}
}