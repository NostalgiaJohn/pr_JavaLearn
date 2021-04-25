class Method3 {
	public static void main(String[] args) {
		int num  = 0;
		
		System.out.println("Before call the method:" + num);
		// 这里是被一个方法的返回值修改了
		num = giveMeFive();
		System.out.println("After call the method:" + num);
	}
	
	/*
	return关键字
		1. 结束当前方法的运行
			方法运行到return时，方法运行结束，return之后的代码不再执行
		2. 可以返回到方法之外的数据
			在return关键字之后的数据，可以返回到方法之外，利用返回值
			
	返回值：
		返回值是当前方法对于方法之外提供的数据和表现。
		需要对应返回的数据，声明对应的返回值类型
		
	【注意】
		方法中如果需要返回值，必有一个明确的return
		方法中返回值类型是void，那么可以使用return作为方法的结束，但return之后不能有任何数据。
		
	需求：
		give Me Five
		需要返回一个int类型数据5

	方法分析：
		public static
		返回值类型：
			5 是一个int类型
		方法名：
			giveMeFive
		形参：
			不需要参数
	方法声明：
		public static int giveMeFive()
	*/
	/**
	* 返回一个int类型数据5
	*
	*@return 返回值为int类型数据5
	*
	*/
	public static int giveMeFive() {
		// return之后的数据回被返回到方法外
		return 5;
	}
}