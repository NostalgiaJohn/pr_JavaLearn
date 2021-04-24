class Method4 {
	public static void main(String[] args) {
		int sum = 0;
		
		System.out.println("Before call the method:" + sum);
		sum = getSumOfTwoNumber(10,20);
		
		System.out.println("After call the method:" + sum);
	}
	
	/*
	需求：
		计算两个int类型数据之和，返回结果
	方法分析：
		public static
		返回值类型：
			int 够用
		方法名：
			getSumOfTwoNumber
		形式参数列表：
			需要两个int类型--(int num1, int num2)
	方法声明：
		public static int getSumOfTwoNumber(int num1, int num2);
	*/
	/**
	* 计算两个int类型数据，并通过返回值返回
	* 
	* @param num1 int类型数据
	* @param num2 int类型数据
	* @return 两个int类型数据之和，返回值类型为int类型
	*/
	public static int getSumOfTwoNumber(int num1, int num2){
		return num1 + num2;
	}
}