// ��ʹ��abs������֮��ľ���ֵ
import java.util.Scanner;

class TwoNumSub {
	public static void main(String[] args) {
		// ��������int���ͱ���
		int num1 = 0;
		int num2 = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("��������������");
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		
		int ret = num1 > num2 ? num1 - num2 : num2 - num1;
		
		System.out.println("ret : " + ret);
	}
}