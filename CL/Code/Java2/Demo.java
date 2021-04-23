class Demo {
	public static void main(String[] args) {
		/* 算术运算符演示 */
		int num1 = 10;
		int num2 = 20;
		
		/*
		1. 变量操作过程中，注意变量的值是否发生更改
		2. 有且只有赋值操作可以修改变量的内容，没有赋值无法更改
		*/
		num2 = num1 + num2; // num1 = 10 num2 = 30
		num2 = num1 + num2; // num1 = 10 num2 = 300
		num2 = num1 / num2; // num1 = 10 num2 = 0
		num2 = num1 * num2; // num1 = 10 num2 = 0
		
		num1 = 10;
		num2 = 20;
		num2 += num1;
		System.out.println(num2); // num2 = 30
		System.out.println(num1); // num1 = 10
	}
}