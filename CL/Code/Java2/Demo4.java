// 导包，让当前代码拥有可以使用Scanner的能力
import java.util.Scanner;

class Demo4 {
	public static void main(String[] args) {
		/*
		int num = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("请输入一个整数：");
		num = sc.nextInt();
		
		System.out.println("num : " + num);
		*/
		char ch = '\0'; // 控制符
		Scanner sc = new Scanner(System.in);
		
		System.out.println("请输入一个字符：");
		ch = sc.next().charAt(0);
		
		System.out.println("ch : " + ch);
	}
}