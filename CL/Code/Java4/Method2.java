class Method2 {
	public static void main(String[] args) {
		// 带有参数的方法一定要提供对应的数据类型--实际参数
		// 调用带参方法，给实际参数时，数据类型要一致
		printIntNumber(10);
		
		// 多个参数的方法中，需要按照形参列表，给予对应的合理参数
		// 参数的个数不允许缺少,顺序也不能随意调整
		// method(int num1, float num2, char ch, double num3);
		printSumOfTwoNumber(5,10);
	}
	
	/*
	参数:
		当前方法执行所需的外部数据
		例如：登录时需要的账号和密码
		
	需求
		展示一个int类型
	方法分析：
		public static
		返回值类型：
			void 没有返回值，Syout不是一个展示数据的方式，是一种反馈。
		方法名：
			printIntNumber 见名知意，小驼峰命名
		形参列表：
			需要打印int类型--int num
			
	方法声明：
		public static void printIntNumber(int num);

	*/
	/**
	* 展示一个int类型数据
	* 
	* @param num 要求用户传入一个人int类型数据
	*/
	public static void printIntNumber(int num) {
		System.out.println("用户提供的int类型数据为：" + num);
	}
	
	/*
	需求：
		打印两个int类型数据之和
	方法分析：
		public static
		返回值类型;
			功能是展示/打印数据，不需要返回值
		方法名：
			printSumOfTwoNumber
		形式参数列表：
			这里需要两个int类型--int num1, int num2
		
	方法声明：
		public static void printSumOfTwoNumber(int num1, int num2)
	*/
	/**
	* 打印两个int类型数据的和
	*
	* @param num1 需要用户提供的int类型数据
	* @param num2 需要用户提供的int类型数据
	*/
	public static void printSumOfTwoNumber(int num1, int num2) {
		System.out.println("Sum : " + (num1 + num2));
	}
}