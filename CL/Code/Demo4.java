// �������õ�ǰ����ӵ�п���ʹ��Scanner������
import java.util.Scanner;

class Demo4 {
	public static void main(String[] args) {
		/*
		int num = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("������һ��������");
		num = sc.nextInt();
		
		System.out.println("num : " + num);
		*/
		char ch = '\0'; // ���Ʒ�
		Scanner sc = new Scanner(System.in);
		
		System.out.println("������һ���ַ���");
		ch = sc.next().charAt(0);
		
		System.out.println("ch : " + ch);
	}
}