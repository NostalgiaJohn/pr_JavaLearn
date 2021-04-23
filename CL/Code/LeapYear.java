import java.util.Scanner;

class LeapYear {
	public static void main(String[] args) {
		int year = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("请输入一个年份：");
		year = sc.nextInt();
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			System.out.println("闰年");
		} else {
			System.out.println("平年");
		}
	}
}