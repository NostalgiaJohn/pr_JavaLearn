class Demo7 {
	public static void main(String[] args) {
		int i = 0;
		
		while (i < 10) {
			System.out.println("���˳���");
			i += 1;
			if (5 == i) {
				System.out.println("continue");
				continue;
			}
			
			// whileѭ���б�����������⣬����5==i֮�������� ��������ѭ��
			// i += 1; 
			
		}
		
		for (int j = 0; j < 10; j++) {
			System.out.println("��ţ��");
			if (5 == j) {
				System.out.println("continue");
				continue;
			}
			
			System.out.println("����ţ����");
		}
	}
}