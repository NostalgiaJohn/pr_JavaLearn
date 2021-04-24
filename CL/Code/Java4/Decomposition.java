/* 
将一个正整数进行分解质数分解操作，例如输入90 输出 2,3,3,5
90 ==》 2 除2 无余数
45 ==》 2 除2 有余数
45 ==》 3 除3 无余数
15 ==》 3 除3 无余数
5  ==》 3 除3 有余数
。。。
1  ==》 循环结束

*/
class Decomposition {
	public static void main(String[] args) {
		System.out.println("第一种方法");
		intDecomposition1(90);
		System.out.println("第二种方法");
		intDecomposition2(90);
	}
	
	/*
	需求：
		正整数进行分解质因数操作，得到结果
	方法分析：
		public static
		返回值类型：
			void --打印结果，不难为自己
		方法名：
			factoringInt
		形式参数列表：
			需要一个int类型--(int num)
	方法声明：
		public static void factoringInt(int num);
	*/
	/**
	* 对一个int类型数据进行因式分解，并得到结果
	* 
	* @param num int类型数据 输入需要因式分解的正整数
	* @param i int类型数据 记录通过计算得到的因数
	* @param j int类型数据 记录该方法所需的循环次数
	*/
	public static void intDecomposition1(int num){
		int j = 0;

		// num会动态改变以减少循环次数
		for (int i = 2; i <= num; i++) {
			j += 1;
			if (num % i == 0) {
				System.out.println(i);
				num /= i;
				i -= 1;
			}
		}
		System.out.println("循环次数：" + j);
	}
	
	public static void intDecomposition2(int num){
		int j = 0;
		
		// 循环优化 在复用性上也是这个更好 
		// num为1时，上面的循环不输出。
		// num/2 或者 Math.sqrt(num) 可以大幅减少循环次数
		for (int i = 2; i <= num/2; i++) {
			j += 1;
			if (num % i == 0) {
				System.out.print(i + " ");
				num /= i;
				i -= 1;
			}
		}
		System.out.print(num);
		System.out.println("\n"+"循环次数：" + j);
	}
}