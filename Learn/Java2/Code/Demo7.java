import java.util.Scanner;

class Demo7 {
	public static void main(String[] args) {
		int score = 0;
		//Scannerɨ��������
		Scanner sc = new Scanner(System.in);
		
		System.out.println("������ѧ���ĳɼ���");
		score = sc.nextInt();
		
		// �û��������ݺϷ����ж�����
		if (score < 0 || score > 100) {
			System.out.println("�������");
			// �����˳�
			System.exit(0);
		}
		//if - else if
		if (score >= 90) {
			System.out.println("����");
		} else if (score >= 80) {
			System.out.println("����");
		} else if (score >= 70) {
			System.out.println("�е�");
		} else if (score >= 60) {
			System.out.println("����");
		} else {
			System.out.println("������");
		}
	}
}