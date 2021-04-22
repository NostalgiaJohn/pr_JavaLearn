import java.util.Scanner;

class Demo8 {
	public static void main(String[] args) {
		int choose = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1. 肥宅快乐水");
		System.out.println("2. 咖啡");
		System.out.println("3. 果汁");
		System.out.println("4. 奶茶");
		System.out.println("请输入您的选择：");
		choose = sc.nextInt();
		
		switch (choose) {
			case 1:
				System.out.println("3RM 肥宅快乐水");
				break;
			case 2:
				System.out.println("42RM 咖啡");
				break;
			case 3:
				System.out.println("5RM 果汁");
				break;
			case 4:
				System.out.println("10RM 奶茶");
				break;
			default:
				System.out.println("并没有这一项哦");
				break;
				
		}
	}
}