class Demo3 {
	public static void main(String[] args) {
		int num = 10;
		boolean ret = 10 > 5 && num++ > 10;
		
		
		System.out.println("num : " + num); // 11
		System.out.println("ret : " + ret); // F --执行完判断后再执行自增
		
		int num1 = 10;
		boolean ret1 = 10 > 15 && num++ >= 10;
		/*
		断路原则问题：
			逻辑与断路原则问题
			在逻辑与表达式中，出现第一个为false条件时，整个表达式结果已经明确，不需要继续执行--节约计算资源，提高效率。
		*/
		System.out.println("num1 : " + num1); // 10
		System.out.println("ret1 : " + ret1); // F
		
		int num2 = 10;
		boolean ret2 = 10 > 5 || ++num2 > 5;
		/*
		断路原则问题：
			逻辑或断路原则问题
			在逻辑或表达式中，出现第一个为true条件时，整个表达式结果已经明确，不需要继续执行--节约计算资源，提高效率。
		*/
		System.out.println("num2 : " + num2); // 10 
		System.out.println("ret2 : " + ret2); // T
	}
}