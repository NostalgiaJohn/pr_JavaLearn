// 不使用abs求两数之差的绝对值
import java.util.Scanner;

class TwoNumSub {
	public static void main(String[] args) {
		// 定义两个int类型变量
		int num1 = 0;
		int num2 = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("请输入两个整数");
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		
		int ret = num1 > num2 ? num1 - num2 : num2 - num1;
		
		System.out.println("ret : " + ret);
	}
}