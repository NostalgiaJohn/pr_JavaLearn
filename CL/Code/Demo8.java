import java.util.Scanner;

class Demo8 {
	public static void main(String[] args) {
		int choose = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1. ��լ����ˮ");
		System.out.println("2. ����");
		System.out.println("3. ��֭");
		System.out.println("4. �̲�");
		System.out.println("����������ѡ��");
		choose = sc.nextInt();
		
		switch (choose) {
			case 1:
				System.out.println("3RM ��լ����ˮ");
				break;
			case 2:
				System.out.println("42RM ����");
				break;
			case 3:
				System.out.println("5RM ��֭");
				break;
			case 4:
				System.out.println("10RM �̲�");
				break;
			default:
				System.out.println("��û����һ��Ŷ");
				break;
				
		}
	}
}