import java.util.Scanner;

class LeapYear {
	public static void main(String[] args) {
		int year = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("������һ����ݣ�");
		year = sc.nextInt();
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			System.out.println("����");
		} else {
			System.out.println("ƽ��");
		}
	}
}