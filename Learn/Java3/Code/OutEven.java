// ���0-100�е�ż��

class OutEven {
	public static void main(String[] args) {
		/*
		ѭ��ִ����101��
		�ж�ִ����101��
		��λʱ������--202��
		*/
		for (int i = 0; i <= 100; i++) {
			if (i % 2 == 0) {
				System.out.println(i);
			}
		}
		
		System.out.println();
		/*
		ѭ��ִ����51��
		���ж�ִ��
		��λʱ������--51��
		*/
		for (int i = 0; i <= 100; i += 2 ) {
			System.out.println(i);
		}
	}
}