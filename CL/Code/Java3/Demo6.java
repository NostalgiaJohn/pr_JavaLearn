// չʾbreak�ؼ���ʹ�÷�ʽ
class Demo6 {
	public static void main(String[] args) {
		// while ѭ��
		int i = 10;
		
		while (i > 0) {
			System.out.println("������");
			i -= 1;
			
			// ʹ��if��֧�ṹ����������
			// �ڿ�����ʹ��==�жϣ��������㳣����ǰ�������ں�
			if (5 == i) {
				System.out.println("����");
				// ����ѭ����
				break;
			}
		}
		
		int j = 10;
		
		do {
			System.out.println("���ݳ���");
			j -= 1;
			
			if (5 == j) {
				System.out.println("�����");
				break;
			}
		} while (j > 0);
		
		for (int k = 0; k < 10; k++) {
			System.out.println("������򣬾�����������");
			if (5 == k) {
				System.out.println("���ΰ�");
				break;
			}
		}
	}
}