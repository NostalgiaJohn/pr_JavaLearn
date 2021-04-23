class Demo11 {
	public static void main(String[] args) {
		int num = 10;
		
		if (num > 5) {
			// num2 是一个局部变量，有且只能在当前if大括号中使用
			int num2 = 20;
			
			// 可以使用num 其作用范围是整个main方法代码框
			// 在一个变量的作用域范围内，不能重定义同名变量。
			// int num = 10;
			
		}
		
		System.out.println(num);
		// System.out.println(num2);
		
	}
}